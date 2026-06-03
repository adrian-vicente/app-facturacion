package com.gestion.facturacion.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movimientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movimiento {

    // Declaración de atributos 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String concepto;
    private String descripcion;
    private double importe;
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento;

} // class