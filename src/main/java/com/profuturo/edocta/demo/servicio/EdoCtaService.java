package com.profuturo.edocta.demo.servicio;

import com.profuturo.edocta.demo.excepciones.BadRequestException;
import com.profuturo.edocta.demo.excepciones.NoAuthException;
import com.profuturo.edocta.demo.excepciones.NotFoundException;
import com.profuturo.edocta.demo.excepciones.ServerUnavailableException;
import com.profuturo.edocta.demo.modelos.entrada.ActualizarMovimientosIn;
import com.profuturo.edocta.demo.modelos.entrada.GuardarMovimientosIn;
import com.profuturo.edocta.demo.modelos.salida.MovimientosOut;

import java.util.List;

public interface EdoCtaService {

	public List<MovimientosOut> consultarMovimientos(String numCuenta) throws NotFoundException, BadRequestException, NoAuthException, ServerUnavailableException, Exception;
	long guardarMovimientos(GuardarMovimientosIn in) throws NotFoundException, BadRequestException, NoAuthException, ServerUnavailableException, Exception;
	long actualizarMovimientos(ActualizarMovimientosIn in) throws NotFoundException, BadRequestException, NoAuthException, ServerUnavailableException, Exception;
}
