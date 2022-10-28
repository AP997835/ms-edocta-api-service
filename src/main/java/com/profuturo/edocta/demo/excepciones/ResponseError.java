package com.profuturo.edocta.demo.excepciones;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "ResponseError", description = "Respuesta de error a un fallo en el sistema")
@JsonPropertyOrder({ "ResponseError" })
public class ResponseError {

    @JsonProperty("errorCode")
    @ApiModelProperty(value = "errorCode - codigo asignado a un error", required = true)
    private int errorCode;

    @JsonProperty("status")
    @ApiModelProperty(value = "status - codigo asignado a un error")
    private int status;

    @JsonProperty("httpStatus")
    @ApiModelProperty(value = "httpStatus", required = true)
    private String httpStatus;


    @JsonProperty("errorMessage")
    @ApiModelProperty(value = "errorMessage - error descrito de manera clara", required = true)
    private String errorMessage;


    @JsonProperty("rootErrorMessage")
    @ApiModelProperty(value = "rootErrorMessage error general", required = true)
    private String rootErrorMessage;

    @JsonProperty("errorList")
    @ApiModelProperty(value = "errorList lista de errores", required = true)
    private List<String> errorList;
}