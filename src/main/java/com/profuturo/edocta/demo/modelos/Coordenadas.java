package com.profuturo.edocta.demo.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordenadas {
	@JsonProperty("latitud")
	private String latitud = null;

	@JsonProperty("longitud")
	private String longitud = null;

}
