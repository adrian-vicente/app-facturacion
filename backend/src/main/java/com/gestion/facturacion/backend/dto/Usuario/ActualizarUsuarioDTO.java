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
public class ActualizarUsuarioDTO {

    // Declaración de atributos 

    @NotBlank(message = "No puedes dejar al usuario sin nombre.")
    @Size(min = 5, max = 100, message = "El nombre de usuario debe tener entre 5 y 100 carácteres")
    private String nombre;

    @NotBlank(message = "No puedes dejar al usuario sin correo.")
    @Email(message = "El email no tiene el formato correcto.")
    private String email;

    @NotBlank(message = "El usuario debe tener una password asociada.")
    @Size(min = 5, max = 255, message = "La password debe tener entre 5 y 255 carácteres.")
    private String password;

}
