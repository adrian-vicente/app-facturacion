package com.gestion.facturacion.backend.dto.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResponseDTO {

    // Declaración de atributos 

    private String token;
    private UsuarioDTO usuario;

} // class