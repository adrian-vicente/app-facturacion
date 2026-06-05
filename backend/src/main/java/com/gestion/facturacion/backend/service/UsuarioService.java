package com.gestion.facturacion.backend.service;

import org.springframework.stereotype.Service;

import com.gestion.facturacion.backend.config.ValidatorConfig;
import com.gestion.facturacion.backend.dto.UsuarioDTO;
import com.gestion.facturacion.backend.model.Usuario;
import com.gestion.facturacion.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    // Inyección de dependencias 

    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;

    }

    // Método de conversión: DTO ==> ENTITY

    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        if ( ValidatorConfig.validarIdentificador(usuarioDTO.getId()) ) {
            usuario.setId(usuarioDTO.getId());

        } // if

        usuario.setNombre(usuarioDTO.getNombre());

        // Devolver el usuario con datos aplicados

        return usuario;

    }

    // Método de conversión: ENTITY ==> DTO

} // class