package com.gestion.facturacion.backend.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "objetivos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ObjetivoAhorro {

    // Declaración de atributos 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private BigDecimal objetivo;
    private BigDecimal ahorrado;

    // Declaración de atributos para las relaciones

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

} // class