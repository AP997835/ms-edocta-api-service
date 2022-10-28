package com.profuturo.edocta.demo.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BitacoraResponseDto {

	private Long idBitacoraProceso;
	private Long httpStatus;
	private String request;
	private String response;
	private String endpoint;
	private Integer lineaNegocio;
}
