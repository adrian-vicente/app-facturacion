package com.gestion.facturacion.backend.dto.Presupuesto;

import java.time.YearMonth;

import org.hibernate.validator.constraints.pl.NIP;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PresupuestoDTO {

    // Declaración de atributos 

    private Long id;
    private double limite;
    private YearMonth periodo;

    // Declaración de atributos para las relaciones
    
    private Long usuario_id;
    private Long categoria_id;

}