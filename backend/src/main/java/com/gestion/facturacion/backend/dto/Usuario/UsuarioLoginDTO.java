package com.gestion.facturacion.backend.dto.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioLoginDTO {

    // Declaración de atributos 

    @NotBlank(message = "El usuario debe tener un nombre asociado.")
    @Size(min = 5, max = 100, message = "El nombre de usuario debe tener entre 5 y 100 carácteres")
    private String nombre;

    @NotBlank(message = "El usuario debe tener un email asociado.")
    @Email(message = "El email no tiene formato correcto")
    private String email;

    @NotBlank(message = "El usuario debe tener una password asociada")
    @Size(min = 5, max = 255, message = "La password debe tener entre 5 y 255 carácteres")
    private String password;

} // class