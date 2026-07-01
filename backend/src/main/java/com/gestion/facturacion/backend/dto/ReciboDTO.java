package com.gestion.facturacion.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReciboDTO {

    // Declaración de atribtos 

    private Long id;
    private String nombreArchivo;
    private String rutaArchivo;

}