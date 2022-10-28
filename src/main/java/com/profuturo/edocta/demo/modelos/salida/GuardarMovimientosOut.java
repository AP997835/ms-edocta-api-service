package com.profuturo.edocta.demo.modelos.salida;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuardarMovimientosOut {

    @JsonProperty("resultado")
    private boolean resultado;

}

