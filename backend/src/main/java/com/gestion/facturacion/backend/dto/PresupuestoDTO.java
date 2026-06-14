package com.gestion.facturacion.backend.dto;

import java.time.YearMonth;

public class PresupuestoDTO {

    // Declaración de atributos 

    private Long id;
    private double limite;
    private YearMonth periodo;

    // Declaración de atributos para las relaciones
    
    private Long usuario_id;
    private Long categoria_id;

}