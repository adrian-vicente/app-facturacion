package com.gestion.facturacion.backend.dto;

import java.math.BigDecimal;

public class ObjetivoAhorroDTO {

    // Declaración de atributos 

    private Long id;
    private String nombre;
    private BigDecimal ahorro;
    private BigDecimal ahorrado;

    // Declaración de atributos para las relaciones 

    private Long usuario_id;

}