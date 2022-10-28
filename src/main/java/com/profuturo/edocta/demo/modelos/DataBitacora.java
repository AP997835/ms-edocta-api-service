package com.profuturo.edocta.demo.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataBitacora {

	@JsonProperty("idProceso")
	private String idProceso;
	@JsonProperty("idSubProceso")
	private String idSubProceso;
	@JsonProperty("idOrigen")
	private String idOrigen;
	@JsonProperty("idFactor")
	private String idFactor;
}
