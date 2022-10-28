package com.profuturo.edocta.demo.modelos.entrada;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarMovimientosIn {

    @JsonProperty("id_movimiento")
    private Long idmovimiento;

    @JsonProperty("id_tipo_cuenta")
    private Long idtipocuenta;

    @JsonProperty("referencia")
    private String referencia;

    @JsonProperty("concepto")
    private String concepto;

    @JsonProperty("monto")
    private BigDecimal monto;

}

