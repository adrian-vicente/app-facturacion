package com.gestion.facturacion.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.facturacion.backend.dto.Usuario.CrearUsuarioDTO;
import com.gestion.facturacion.backend.dto.Usuario.UsuarioDTO;
import com.gestion.facturacion.backend.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

    // Inyección de dependencias 

    private final UsuarioService usuarioService;
    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Creación de un nuevo usuario 

    @PostMapping("/crear")
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody @Valid CrearUsuarioDTO usuarioDTO) throws Exception {
        UsuarioDTO usuario = usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity
            .ok(usuario);

    }

} // class