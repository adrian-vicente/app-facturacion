package com.gestion.facturacion.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestion.facturacion.backend.config.ValidatorConfig;
import com.gestion.facturacion.backend.dto.UsuarioDTO;
import com.gestion.facturacion.backend.model.Usuario;
import com.gestion.facturacion.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    // Inyección de dependencias 

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;

    }

    // Método de conversión: DTO ==> ENTITY

    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        if ( ValidatorConfig.validarIdentificador(usuarioDTO.getId()) ) {
            usuario.setId(usuarioDTO.getId());

        } // if

        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));

        // Devolver el usuario con datos aplicados

        return usuario;

    }

    // Método de conversión: ENTITY ==> DTO

    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        if ( ValidatorConfig.validarIdentificador(usuario.getId()) ) {
            usuarioDTO.setId(usuario.getId());

        } // if

        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());

        return usuarioDTO;

    }

} // class