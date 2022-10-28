package com.profuturo.edocta.demo.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestProcesarFacial {

	@JsonProperty("origen")
	private String origen;
	@JsonProperty("cveEntidad")
	private String cveEntidad;
	@JsonProperty("curp")
	private String curp;
	@JsonProperty("token")
	private String token;
	@JsonProperty("cveOperacion")
	private String cveOperacion;
	@JsonProperty("listaImagen")
	private List<String> listaImagen;

}
