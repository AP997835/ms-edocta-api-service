package com.profuturo.edocta.demo.modelos.salida;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientosTransitionalOut {

    @JsonProperty("id_movimiento")
    private Long id_movimiento;

    @JsonProperty("num_cuenta")
    private String sald_numcu;

    @JsonProperty("concepto")
    private String mov_concepto;

    @JsonProperty("fecha_movimiento")
    private String mov_fecha;

    @JsonProperty("monto")
    private BigDecimal mov_monto;

}

