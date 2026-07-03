package com.gestion.facturacion.backend.dto.Categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    // Declaración de atributos 

    private Long id;
    private String nombre;
    private String descripcion;

}
