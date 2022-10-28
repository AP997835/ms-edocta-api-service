package com.profuturo.edocta.demo.modelos.salida;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientosOut {

    @JsonProperty("id_movimiento")
    private Long id_movimiento;

    @JsonProperty("fecha_movimiento")
    private String fecha_movimiento;

    @JsonProperty("desc_tipo_cuenta")
    private String desc_tipo_cuenta;

    @JsonProperty("numero_cuenta")
    private String numero_cuenta;

    @JsonProperty("referencia")
    private String referencia;

    @JsonProperty("concepto")
    private String concepto;

    @JsonProperty("monto")
    private Long monto;

    @JsonProperty("desc_periodo")
    private String desc_periodo;

}

