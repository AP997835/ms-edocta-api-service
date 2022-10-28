package com.profuturo.edocta.demo.config;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.profuturo.edocta.demo.excepciones.BadRequestException;
import com.profuturo.edocta.demo.excepciones.NoAuthException;
import com.profuturo.edocta.demo.excepciones.NotFoundException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignCustomErrors implements ErrorDecoder {

	Logger logger = LogManager.getLogger(FeignCustomErrors.class);

	@Override
	public Exception decode(String methodKey, Response response) {
		/*
		 * ObjectMapper mapper = new ObjectMapper(); ErrorModel error = null; try {
		 * error = mapper.readValue(response.body().asInputStream(), ErrorModel.class);
		 * } catch (IOException e) { e.printStackTrace();
		 * logger.error("Error[500] Se produjo un error al convertir el response: " +
		 * e.getMessage()); return new Exception(e.getMessage()); }
		 */
		String responseBody;
		String messageError;
		int status = response.status();
		try {
			// Se obtiene la respuesta del error en String
			responseBody = new String(response.body().asInputStream().readAllBytes());
			logger.info(String.format("Response Procesar[%d]: %s", status, responseBody));
		} catch (IOException e) {
			//e.printStackTrace();
			messageError = "Se produjo un error al obtener el response";
			logger.error("Error[500]: " + messageError);
			return new Exception(messageError);
		}
		// Se hace el mapeo de los errores obtenidos en el servicio Valida Usuario
		logger.info("Servicio consumido: " + methodKey);
		if (methodKey.startsWith("IntEnrolamientoFacialFeignClient")) {
			switch (status) {
			case 400:
				logger.warn("Response[400] El cuerpo de la solicitud al servicio Enrolamiento/Validacion Facial no es el esperado "
						+ response.reason());
				return new BadRequestException(responseBody);
			case 401:
				messageError = "No se tiene autorizacion para consumir el servicio Enrolamiento/Validacion Facial";
				logger.warn("Response[401] " + messageError);
				return new NoAuthException(responseBody);
			case 404:
				messageError = "No se encontró el recurso solicitado";
				logger.warn("Response[404] " + messageError);
				return new NotFoundException(responseBody);
			default:
				messageError = "Se produjo un error al consumir el servicio Enrolamiento/Validacion Facial";
				logger.error("Response[500] ");
				return new Exception(responseBody);
			}

		} else if (methodKey.startsWith("IntBitacoraFeignClient")) {
			// Se hace el mapeo de los errores obtenidos en el servicio para almacenar las
			// bitacoras
			switch (status) {
			case 400:
				logger.warn(
						"Response[400] El cuerpo de la solicitud al servicio gestion-autenticacion no es el esperado "
								+ response.reason());
				return new BadRequestException(responseBody);
			case 401:
				messageError = "No se tiene autorizacion para consumir el servicio gestion-autenticacion";
				logger.warn("Response[401] " + messageError);
				return new NoAuthException(responseBody);
			case 404:
				messageError = "No se encontró el recurso solicitado";
				logger.warn("Response[404] " + messageError);
				return new NotFoundException(responseBody);
			default:
				messageError = "Se produjo un error al consumir el servicio gestion-autenticacion";
				logger.error("Response[500] " + messageError);
				return new Exception(responseBody);
			}
		}
		messageError = "No hay un mapeo de errores para el cliente feign: " + methodKey;
		logger.error("Error Interno: " + messageError);
		return new Exception(messageError);
	}

}
