package com.gestion.facturacion.backend.mapper;

import org.springframework.stereotype.Component;

import com.gestion.facturacion.backend.config.ValidatorConfig;
import com.gestion.facturacion.backend.dto.Usuario.ActualizarUsuarioDTO;
import com.gestion.facturacion.backend.dto.Usuario.CrearUsuarioDTO;
import com.gestion.facturacion.backend.dto.Usuario.UsuarioDTO;
import com.gestion.facturacion.backend.model.Usuario;

@Component
public class UsuarioMapper {

    // Método de conversión a entidad para creación de nuevo usuario 

    public Usuario toEntity(CrearUsuarioDTO dto) {
        Usuario usuario = new Usuario();
            usuario.setNombre(dto.getNombre());
            usuario.setEmail(dto.getEmail());
            usuario.setPassword(dto.getPassword());

        // Devolver el dto

        return usuario;

    }

    // Método de conversión a DTO para traspaso de datos 

    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        // Comprobar si el usuario tiene identificador

        if(ValidatorConfig.validarIdentificador(usuario.getId())) usuarioDTO.setId(usuario.getId());    

        // Rellenar los campos restantes del objeto 

        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());

        // Devolver el dto

        return usuarioDTO;

    }

    // Método para actualizar la información de un usuario

    public void actualizarUsuario(Usuario usuario, ActualizarUsuarioDTO dto) {

        
    }

} // class