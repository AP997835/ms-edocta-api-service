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
public class XMLlocation {

	/*
	 * @ApiModelProperty(position = 1, example = "String")
	 * 
	 * @JsonProperty("node") private String node;
	 * 
	 * @ApiModelProperty(position = 2, example = "String")
	 * 
	 * @JsonProperty("pipeline") private String pipeline;
	 * 
	 * @ApiModelProperty(position = 3, example = "String")
	 * 
	 * @JsonProperty("stage") private String stage;
	 * 
	 * @ApiModelProperty(position = 4, example = "String")
	 * 
	 * @JsonProperty("path") private String path;
	 */

	@ApiModelProperty(position = 1, example = "String")
	@JsonProperty("message")
	private List<String> message;

}
