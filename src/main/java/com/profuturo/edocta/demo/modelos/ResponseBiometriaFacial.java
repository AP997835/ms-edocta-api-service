package com.profuturo.edocta.demo.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBiometriaFacial {

	@JsonProperty("curp")
	@ApiModelProperty(position = 1, example = "AAAA900909HDFXXX09", value = "Es el curp del usuario")
	private String curp;

	@JsonProperty("token")
	@ApiModelProperty(position = 2, example = "KInio8EOGgdcZWCTQnlxiiP3tDnwp0kBiDE3wTOP8AjshylnpV7lqndrk=", value = "Token utilizado para la operacion")
	private String token;

	@JsonProperty("cveEntidad")
	@ApiModelProperty(position = 2, required = true, example = "534", notes = "Clave de linea de negocio que realizará la solicitud")
	private String cveEntidad;

	@JsonProperty("resultadoOperacion")
	@ApiModelProperty(position = 3, example = "01 | 02", notes = "Resultado de la operacion: 01 - Solicitud procesada | 02 - Solicitud rechazada")
	private String resultadoOperacion;

	@JsonProperty("listaDiagnosticosOp")
	@ApiModelProperty(position = 4, example = "[\"A22\", \"A30\"]", notes = "Lista de diagnosticos de la operacion realizada, los codigos se ajustan de acuerdo al catalogo")
	private List<String> listaDiagnosticosOp;

	@JsonProperty("resultadoValidacion")
	@ApiModelProperty(position = 5, example = "MATCH | NOMATCH", notes = "MATCH - Existe coincidencia con las imagenes | NOMATCH - No existe coincidencia con las imagenes")
	private String resultadoValidacion;

	@JsonProperty("calificacion")
	@ApiModelProperty(position = 6, example = "XXX")
	private String calificacion;

	@JsonProperty("enrolado")
	@ApiModelProperty(position = 7, example = "00 | O1", notes = "00 - No existe enrolamiento | 01 - Existe enrolamiento")
	private String enrolado;

}
