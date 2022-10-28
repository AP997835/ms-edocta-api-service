package com.profuturo.edocta.demo.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BitacoraRequest {
	@JsonProperty("proceso")
	private ElementoId proceso = null;

	@JsonProperty("subproceso")
	private ElementoId subproceso = null;

	@JsonProperty("origen")
	private ElementoId origen = null;

	@JsonProperty("factor")
	private ElementoId factor = null;

	@JsonProperty("estatus")
	private ElementoId estatus = null;

	@JsonProperty("tipo")
	private ElementoId tipo = null;

	@JsonProperty("transaccion")
	private ElementoId transaccion = null;

	@JsonProperty("coordenadas")
	private Coordenadas coordenadas = null;
}
