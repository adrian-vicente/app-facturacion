package com.gestion.facturacion.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "presupuestos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Presupuesto {

    // Declaración de atributos 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double limite;
    private int mes;

} // class