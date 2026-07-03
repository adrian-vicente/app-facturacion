package com.gestion.facturacion.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestion.facturacion.backend.config.ValidatorConfig;
import com.gestion.facturacion.backend.dto.Usuario.CrearUsuarioDTO;
import com.gestion.facturacion.backend.dto.Usuario.UsuarioDTO;
import com.gestion.facturacion.backend.exception.EmailAlreadyExistsException;
import com.gestion.facturacion.backend.exception.UsuarioAlreadyExistsException;
import com.gestion.facturacion.backend.exception.UsuarioEmptyException;
import com.gestion.facturacion.backend.exception.UsuarioFieldsNoCompletedException;
import com.gestion.facturacion.backend.exception.UsuarioNotFoundException;
import com.gestion.facturacion.backend.mapper.UsuarioMapper;
import com.gestion.facturacion.backend.model.Usuario;
import com.gestion.facturacion.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    // Inyección de dependencias 

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;

    }

    // Método para crear un nuevo usuario

    public Long crearUsuario(CrearUsuarioDTO crearUsuarioDTO) throws Exception {
    
        // Validaciones y comprobaciones

        if(!ValidatorConfig.validarObjeto(crearUsuarioDTO)) {
            throw new UsuarioEmptyException("No se puede crear el usuario, no tiene datos asociados.");
        }

        if(!(crearUsuarioDTO.getEmail().length() >= 1)) {
            throw new UsuarioFieldsNoCompletedException("El email del usuario no está rellenado, rellénalo para poder crear el usuario.");
        }

        if(usuarioRepository.existsByNombre(crearUsuarioDTO.getNombre())) {
            throw new UsuarioAlreadyExistsException("Ya existe un usuario con nombre: " + crearUsuarioDTO.getNombre());
        }

        if(usuarioRepository.existsByEmail(crearUsuarioDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Ya existe un usuario con email: " + crearUsuarioDTO.getEmail());
        }

        // Cifrar la password

        crearUsuarioDTO.setPassword( passwordEncoder.encode(crearUsuarioDTO.getPassword()) );

        // Asignación de roles

        // Return id usuario

        Usuario usuarioCreado = usuarioRepository.save(usuarioMapper.toEntity(crearUsuarioDTO));
        return usuarioCreado.getId();

    }

    // Método para obtener un usuario a partir del identificador

    // Método para obtener un usuario a partir de un token 

    // Método para obtener todos los usuarios 

    // Método para actualizar un usuario 

    // Método para eliminar un usuario por el identificador 

    // Método para cambiar el estado del usuario 

    // Método para comprobar si existe un usuario por correo 

    // Método para saber si existe un usuario a partir de un username 

    // Método para cambiar la password de un usuario 

    // Método para actualizar la foto de perfil del usuario

} // class