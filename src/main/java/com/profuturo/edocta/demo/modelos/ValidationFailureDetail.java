package com.profuturo.edocta.demo.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationFailureDetail {
	@JsonProperty("message")
	private List<String> message;

	@JsonProperty("xmlLocation")
	private List<XMLlocation> xmlLocation;
}
	