package com.gestion.facturacion.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.facturacion.backend.dto.Usuario.LoginResponseDTO;
import com.gestion.facturacion.backend.dto.Usuario.UsuarioLoginDTO;
import com.gestion.facturacion.backend.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // Inyección de dependencias

    private final UsuarioService usuarioService;
    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Método para iniciar sesión 

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> iniciarSesion(@RequestBody @Valid UsuarioLoginDTO usuarioLoginDTO) throws Exception {
        LoginResponseDTO loginResponseDTO = usuarioService.iniciarSesion(usuarioLoginDTO);
        return ResponseEntity
            .ok(loginResponseDTO);

    }

} // class