package com.profuturo.edocta.demo.dao;

import com.profuturo.edocta.demo.excepciones.SQLInsertarException;
import com.profuturo.edocta.demo.modelos.entrada.ActualizarMovimientosIn;
import com.profuturo.edocta.demo.modelos.entrada.GuardarMovimientosIn;
import com.profuturo.edocta.demo.modelos.salida.MovimientosOut;

import java.util.List;

public interface EdoCtaResponseDao {
	List<MovimientosOut> getMovimientosDao(String numCuenta) throws SQLInsertarException;
	public int insertMovimientosResponse(GuardarMovimientosIn in,Long IdCliente) throws SQLInsertarException;
	public Long obtieneIdClientenumCuenta(GuardarMovimientosIn in) throws SQLInsertarException;
	public int actualizarMovimientosResponse(ActualizarMovimientosIn in) throws SQLInsertarException;
}
