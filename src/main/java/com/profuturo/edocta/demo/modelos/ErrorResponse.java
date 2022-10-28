package com.profuturo.edocta.demo.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	@ApiModelProperty(position = 1, required = true, example = "XXX", notes = "Codigo del error producido")
	@JsonProperty("status")
	private String status;
	@ApiModelProperty(position = 2, required = true, example = "Tipo de error", notes = "Descripcion del error que se produjo al hacer la solicitud")
	@JsonProperty("error")
	private String error;
	@ApiModelProperty(position = 3, required = true, example = "Mensaje del error", notes = "Mensaje describiendo el motivo del error")
	@JsonProperty("message")
	private String message;
	@ApiModelProperty(position = 4, required = true, example = "Path consultado", notes = "Patn del controlador que se consulto")
	@JsonProperty("path")
	private String path;

}
