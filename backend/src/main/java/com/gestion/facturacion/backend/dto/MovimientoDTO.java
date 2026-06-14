package com.gestion.facturacion.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.gestion.facturacion.backend.model.TipoMovimiento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovimientoDTO {

    // Declaración de atributos 

    private Long id;
    private String concepto;
    private String descripcion;
    private BigDecimal importe;
    private LocalDate fecha;
    private TipoMovimiento tipoMovimiento;

    // Declaración de atributos para las relaciones 

    private Long usuario_id;
    private Long categoria_id;

}
