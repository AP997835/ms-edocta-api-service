package com.profuturo.edocta.demo.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import com.profuturo.edocta.demo.excepciones.BadRequestException;
import com.profuturo.edocta.demo.excepciones.NoAuthException;
import com.profuturo.edocta.demo.excepciones.NotFoundException;
import com.profuturo.edocta.demo.excepciones.ServerUnavailableException;
import com.profuturo.edocta.demo.modelos.entrada.ActualizarMovimientosIn;
import com.profuturo.edocta.demo.modelos.entrada.GuardarMovimientosIn;
import com.profuturo.edocta.demo.modelos.entrada.GuardarMovimientosTransitionalIn;
import com.profuturo.edocta.demo.modelos.salida.MovimientosOut;
import com.profuturo.edocta.demo.modelos.salida.MovimientosTransitionalOut;
import com.profuturo.edocta.demo.servicio.EdoCtaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.RetryableException;

@Service
public class EdoCtaServiceImpl implements EdoCtaService {

	Logger logger = LogManager.getLogger(EdoCtaServiceImpl.class);

	@Autowired
	private com.profuturo.edocta.demo.dao.EdoCtaResponseDao EdoCtaResponseDao;
	@Autowired
	private EdoCtaService intBitacoraServicio;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<MovimientosOut> consultarMovimientos(String numCuenta) throws NotFoundException, BadRequestException, NoAuthException, ServerUnavailableException, Exception {
		logger.info("consultarMovimientos Service Impl"+numCuenta);
		List<MovimientosOut> retorno=new ArrayList<MovimientosOut>();
		try {

			retorno=EdoCtaResponseDao.getMovimientosDao(numCuenta);
			if(retorno.size()==0){
				throw new NotFoundException("No se encontró resultado");
			}
		} catch (Exception e) {


		}
		/*} catch (NotFoundException e) {

			throw new NotFoundException("No se encontró el recurso solicitado");
		} catch (BadRequestException e) {

			throw new BadRequestException(
					"El cuerpo de la solicitud al servicio Movimientos no es el esperado");
		} catch (NoAuthException e) {

			throw new NoAuthException(
					"No se tiene autorizacion para consumir el servicio Movimientos");
		} catch (Throwable e) {
			if (e.getClass() == RetryableException.class) {
				throw new ServerUnavailableException(
						"No se logró establecer conexion con el servicio Movimientos");
			} else {
				throw new Exception("Hubo un error interno: " + e.getCause().getMessage());
			}
		} finally {
			logger.info("Fin Servicio Movimientos Impl");
		}*/

		return retorno;

	}

	@Override
	public long guardarMovimientos(GuardarMovimientosIn in) throws NotFoundException, BadRequestException, NoAuthException, ServerUnavailableException, Exception {
		long retorno=0;
		try {
			long idcliente=EdoCtaResponseDao.obtieneIdClientenumCuenta(in);
			if(idcliente>0){
				retorno=EdoCtaResponseDao.insertMovimientosResponse(in,idcliente);
			}else{
				throw new NotFoundException("No se encontró el Numero Cuenta en la BD");
			}
		} catch (NotFoundException e) {
			throw new NotFoundException("No se encontró el recurso solicitado");
		} catch (BadRequestException e) {
			throw new BadRequestException(
					"El cuerpo de la solicitud al servicio Guardar Movimientos no es el esperado");
		} catch (NoAuthException e) {
			throw new NoAuthException(
					"No se tiene autorizacion para consumir el servicio Guardar Movimientos");
		} catch (Throwable e) {
			if (e.getClass() == RetryableException.class) {
				throw new ServerUnavailableException(
						"No se logró establecer conexion con el servicio Movimientos");
			} else {
				throw new Exception("Hubo un error interno: " + e.getCause().getMessage());
			}
		} finally {
			logger.info("Fin Servicio Movimientos Impl");
		}

		return retorno;
	}

	@Override
	public long actualizarMovimientos(ActualizarMovimientosIn in) throws NotFoundException, BadRequestException, NoAuthException, ServerUnavailableException, Exception {
		long retorno=0;
		try {

			retorno=EdoCtaResponseDao.actualizarMovimientosResponse(in);

		} catch (NotFoundException e) {
			throw new NotFoundException("No se encontró el recurso solicitado");
		} catch (BadRequestException e) {
			throw new BadRequestException(
					"El cuerpo de la solicitud al servicio Actualizar Movimientos no es el esperado");
		} catch (NoAuthException e) {
			throw new NoAuthException(
					"No se tiene autorizacion para consumir el servicio Actualizar Movimientos");
		} catch (Throwable e) {
			if (e.getClass() == RetryableException.class) {
				throw new ServerUnavailableException(
						"No se logró establecer conexion con el servicio Movimientos");
			} else {
				throw new Exception("Hubo un error interno: " + e.getCause().getMessage());
			}
		} finally {
			logger.info("Fin Servicio Movimientos Impl");
		}

		return retorno;
	}

	@Override
	public List<MovimientosTransitionalOut> consultarMovimientosTransitional(String numCuenta) throws NotFoundException, BadRequestException, NoAuthException, ServerUnavailableException, Exception {
		logger.info("consultarMovimientosTransitional Service Impl"+numCuenta);
		List<MovimientosTransitionalOut> retorno=new ArrayList<MovimientosTransitionalOut>();
		try {

			retorno=EdoCtaResponseDao.getMovimientosDaoTransitional(numCuenta);
			if(retorno.size()==0){
				throw new NotFoundException("No se encontró resultado");
			}
		} catch (Exception e) {


		}

		return retorno;
	}

	@Override
	public long guardarMovimientosTransitional(GuardarMovimientosTransitionalIn in) throws NotFoundException, BadRequestException, NoAuthException, ServerUnavailableException, Exception {
		long retorno=0;
		try {

				retorno=EdoCtaResponseDao.insertMovimientosResponseTransitionalIn(in);

		} catch (NotFoundException e) {
			throw new NotFoundException("No se encontró el recurso solicitado");
		} catch (BadRequestException e) {
			throw new BadRequestException(
					"El cuerpo de la solicitud al servicio Guardar Movimientos no es el esperado");
		} catch (NoAuthException e) {
			throw new NoAuthException(
					"No se tiene autorizacion para consumir el servicio Guardar Movimientos");
		} catch (Throwable e) {
			if (e.getClass() == RetryableException.class) {
				throw new ServerUnavailableException(
						"No se logró establecer conexion con el servicio Movimientos");
			} else {
				throw new Exception("Hubo un error interno: " + e.getCause().getMessage());
			}
		} finally {
			logger.info("Fin Servicio Movimientos Impl");
		}

		return retorno;
	}


}
