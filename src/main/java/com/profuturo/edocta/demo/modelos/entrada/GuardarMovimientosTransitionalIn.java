package com.profuturo.edocta.demo.modelos.entrada;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuardarMovimientosTransitionalIn {

    @JsonProperty("numeroCuenta")
    private String numeroCuenta;

    @JsonProperty("concepto")
    private String concepto;

    @JsonProperty("monto")
    private BigDecimal monto;

}

