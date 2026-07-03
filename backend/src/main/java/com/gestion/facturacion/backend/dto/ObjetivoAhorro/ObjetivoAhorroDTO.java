package com.gestion.facturacion.backend.dto.ObjetivoAhorro;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ObjetivoAhorroDTO {

    // Declaración de atributos 

    private Long id;
    private String nombre;
    private BigDecimal objetivo;
    private BigDecimal ahorrado;

    // Declaración de atributos para las relaciones 

    private Long usuario_id;

}