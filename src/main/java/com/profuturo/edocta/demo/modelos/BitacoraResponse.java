package com.profuturo.edocta.demo.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BitacoraResponse {

	@JsonProperty("fechaCreacion")
	private String fechaCreacion;
	@JsonProperty("id")
	private String id;
}
