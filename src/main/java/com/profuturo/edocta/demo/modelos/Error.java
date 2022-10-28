package com.profuturo.edocta.demo.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {

	@ApiModelProperty(position = 1, example = "String")
	@JsonProperty("codigo")
	private String codigo;

	@ApiModelProperty(position = 2, example = "String")
	@JsonProperty("descripcion")
	private Descripcion descripcion;

	@ApiModelProperty(position = 3, example = "String")
	@JsonProperty("locacion")
	private String locacion;

}
