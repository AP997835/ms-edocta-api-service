package com.profuturo.edocta.demo.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.profuturo.edocta.demo.config.YamlPropertySourceFactory;
import com.profuturo.edocta.demo.dao.EdoCtaResponseDao;
import com.profuturo.edocta.demo.excepciones.NotFoundException;
import com.profuturo.edocta.demo.excepciones.SQLInsertarException;
import com.profuturo.edocta.demo.modelos.entrada.ActualizarMovimientosIn;
import com.profuturo.edocta.demo.modelos.entrada.GuardarMovimientosIn;
import com.profuturo.edocta.demo.modelos.entrada.GuardarMovimientosTransitionalIn;
import com.profuturo.edocta.demo.modelos.salida.MovimientosOut;
import com.profuturo.edocta.demo.modelos.salida.MovimientosTransitionalOut;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@PropertySource(value = "classpath:querys.yaml", factory = YamlPropertySourceFactory.class)
public class EdoCtaResponseDaoImpl implements EdoCtaResponseDao {
	@Autowired
	@Qualifier("jdbcAut")
	private JdbcTemplate jdbcAut;

	@Value("${movimientos.insertMovimientoResponse}")
	private String INSERT_MOVIMIENTOS_RESPONSE;

	@Value("${movimientos.insertMovimientoResponseTrans}")
	private String INSERT_MOVIMIENTOS_RESPONSE_TRANS;

	@Value("${movimientos.actualizarMovimientoResponse}")
	private String ACTUALIZAR_MOVIMIENTOS_RESPONSE;

	@Value("${selectMovimientos}")
	private String SELECT_MOVIMIENTOS_NUMCUENTA;

	@Value("${selectMovimientosTrans}")
	private String SELECT_MOVIMIENTOS_NUMCUENTA_TRANSTIONAL;

	@Value("${selectIdClientezXnumCuenta}")
	private String SELECT_ID_PERSONA_NUM_CUENTA;

	Logger logger = LogManager.getLogger(EdoCtaResponseDaoImpl.class);

	@Override
	public List<MovimientosOut> getMovimientosDao(String numCuenta) throws SQLInsertarException {
		List<MovimientosOut> resultado = null;
		try {
			resultado = jdbcAut.query(SELECT_MOVIMIENTOS_NUMCUENTA, new Object[] { numCuenta },  new RowMapper<MovimientosOut>()  {
				@Override
				public MovimientosOut mapRow(ResultSet rs, int rowNum) throws SQLException {
					MovimientosOut configrespuesta = new MovimientosOut();
					configrespuesta.setId_movimiento(rs.getLong("ID_MOVIMIENTO"));
					configrespuesta.setFecha_movimiento(rs.getString("FECHA_MOVIMIENTO"));
					configrespuesta.setDesc_tipo_cuenta(rs.getString("DESC_TIPO_CUENTA"));
					configrespuesta.setNumero_cuenta(rs.getString("NUMERO_CUENTA"));
					configrespuesta.setReferencia(rs.getString("REFERENCIA"));
					configrespuesta.setConcepto(rs.getString("CONCEPTO"));
					configrespuesta.setMonto(rs.getLong("MONTO"));
					configrespuesta.setDesc_periodo(rs.getString("DESC_PERIODO"));
					return configrespuesta;
				}
			});
			if (resultado == null) {
				throw new RuntimeException("No se logr?? encontrar movimientos asociados " + numCuenta);
			}
			return resultado;
		} catch (RuntimeException e) {
			logger.error("ERROR - Ocurrio un error al obtener la movimientos de la BD: " + e.getMessage());
			throw new SQLInsertarException("Ocurrio un error al obtener movimientos de la BD");
		}
	}
	@Transactional
	@Override
	public int insertMovimientosResponse(GuardarMovimientosIn in,Long IdCliente) throws SQLInsertarException {
		int exito = 0;
		try {
			exito = jdbcAut.update(INSERT_MOVIMIENTOS_RESPONSE,
					new Object[] { in.getConcepto(), in.getReferencia(),
							in.getMonto(), IdCliente,in.getIdtipocuenta()});
		} catch (RuntimeException e) {
			logger.error("ERROR - Ocurrio un error al insertar el movimientos en la BD: " + e.getMessage());
			throw new SQLInsertarException("Ocurrio un error al insertar el movimiento en la BD");
		}
		return exito;
	}

	@Override
	public Long obtieneIdClientenumCuenta(GuardarMovimientosIn in) throws SQLInsertarException {
		Long idPersona = (long) -1;
		try {
			final String id = jdbcAut.queryForObject(SELECT_ID_PERSONA_NUM_CUENTA, new Object[] { in.getNumeroCuenta() }, String.class);
			if(id==null){
				idPersona=(long)0;
			}else{
				idPersona = Long.valueOf(id);
			}

		} catch (Exception e) {
			throw new NotFoundException("No se encontr?? el Numero Cuenta en la BD");
		}
		return idPersona;
	}

	@Transactional
	@Override
	public int actualizarMovimientosResponse(ActualizarMovimientosIn in) throws SQLInsertarException {
		int exito = 0;
		try {
			exito = jdbcAut.update(ACTUALIZAR_MOVIMIENTOS_RESPONSE,
					new Object[] {in.getIdtipocuenta(), in.getReferencia(), in.getConcepto(),
							in.getMonto(),in.getIdmovimiento()});
		} catch (RuntimeException e) {
			logger.error("ERROR - Ocurrio un error al actualizar el movimientos en la BD: " + e.getMessage());
			throw new SQLInsertarException("Ocurrio un error al actualizar el movimiento en la BD");
		}
		return exito;
	}

	@Override
	public List<MovimientosTransitionalOut> getMovimientosDaoTransitional(String numCuenta) throws SQLInsertarException {
		List<MovimientosTransitionalOut> resultado = null;
		try {
			resultado = jdbcAut.query(SELECT_MOVIMIENTOS_NUMCUENTA_TRANSTIONAL, new Object[] { numCuenta },  new RowMapper<MovimientosTransitionalOut>()  {
				@Override
				public MovimientosTransitionalOut mapRow(ResultSet rs, int rowNum) throws SQLException {
					MovimientosTransitionalOut configrespuesta = new MovimientosTransitionalOut();
					configrespuesta.setId_movimiento(rs.getLong("ID_MOVIMIENTO"));
					configrespuesta.setSald_numcu(rs.getString("SALD_NUMCUE"));
					configrespuesta.setMov_concepto(rs.getString("MOV_CONCEPTO"));
					configrespuesta.setMov_fecha(rs.getString("MOV_FECHA"));
					configrespuesta.setMov_monto(new BigDecimal(rs.getLong("MOV_MONTO")));
					return configrespuesta;
				}
			});
			if (resultado == null) {
				throw new RuntimeException("No se logr?? encontrar movimientos asociados " + numCuenta);
			}
			return resultado;
		} catch (RuntimeException e) {
			logger.error("ERROR - Ocurrio un error al obtener la movimientos de la BD: " + e.getMessage());
			throw new SQLInsertarException("Ocurrio un error al obtener movimientos de la BD");
		}
	}

	@Override
	public int insertMovimientosResponseTransitionalIn(GuardarMovimientosTransitionalIn in) throws SQLInsertarException {
		int exito = 0;
		try {
			exito = jdbcAut.update(INSERT_MOVIMIENTOS_RESPONSE_TRANS,
					new Object[] { in.getNumeroCuenta(), in.getConcepto(),
							in.getMonto()});
		} catch (RuntimeException e) {
			logger.error("ERROR - Ocurrio un error al insertar el movimientos en la BD: " + e.getMessage());
			throw new SQLInsertarException("Ocurrio un error al insertar el movimiento en la BD");
		}
		return exito;
	}


}
