package com.gestion.facturacion.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestion.facturacion.backend.config.ValidatorConfig;
import com.gestion.facturacion.backend.dto.Usuario.CrearUsuarioDTO;
import com.gestion.facturacion.backend.dto.Usuario.LoginResponseDTO;
import com.gestion.facturacion.backend.dto.Usuario.UsuarioDTO;
import com.gestion.facturacion.backend.dto.Usuario.UsuarioLoginDTO;
import com.gestion.facturacion.backend.exception.EmailAlreadyExistsException;
import com.gestion.facturacion.backend.exception.PasswordNotMatchException;
import com.gestion.facturacion.backend.exception.UsuarioAlreadyExistsException;
import com.gestion.facturacion.backend.exception.UsuarioEmptyException;
import com.gestion.facturacion.backend.exception.UsuarioFieldsNoCompletedException;
import com.gestion.facturacion.backend.exception.UsuarioNotFoundException;
import com.gestion.facturacion.backend.mapper.UsuarioMapper;
import com.gestion.facturacion.backend.model.Usuario;
import com.gestion.facturacion.backend.repository.UsuarioRepository;
import com.gestion.facturacion.backend.security.JwtService;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    // Inyección de dependencias 

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, UsuarioMapper usuarioMapper, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;

    }

    // Método para crear un nuevo usuario

    @Transactional
    public UsuarioDTO crearUsuario(CrearUsuarioDTO crearUsuarioDTO) throws Exception {
    
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
        
        crearUsuarioDTO.setPassword( passwordEncoder.encode(crearUsuarioDTO.getPassword()) );

        Usuario usuarioCreado = usuarioRepository.save(usuarioMapper.toEntity(crearUsuarioDTO));
        return usuarioMapper.toDTO(usuarioCreado);

    }

    // Método para iniciar sesión

    public LoginResponseDTO iniciarSesion(UsuarioLoginDTO usuarioLoginDTO) throws Exception {
        Usuario usuario = usuarioRepository.findByEmail(usuarioLoginDTO.getEmail())
            .orElseThrow(() -> new UsuarioNotFoundException("No se ha encontrado ningún usuario con email: " + usuarioLoginDTO.getEmail()));

        if(!passwordEncoder.matches(usuarioLoginDTO.getPassword(), usuario.getPassword())) {
            throw new PasswordNotMatchException("La contraseña introducida es inválida.");
        }

        return new LoginResponseDTO(jwtService.generarToken(usuario), usuarioMapper.toDTO(usuario));

    }

    // Obtener usuario a partir de id

    @Transactional
    public UsuarioDTO getUsuarioById(Long id) throws UsuarioNotFoundException {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new UsuarioNotFoundException("No se ha encontrado a ningún usuario con id: " + id));

        return usuarioMapper.toDTO(usuario);

    }

    // Método para obtener un usuario a partir de un token 

    // Método para obtener todos los usuarios 

    // Método para actualizar un usuario 

    // Método para eliminar un usuario por el identificador 

    // Método para cambiar el estado del usuario 

    // Método para saber si existe un usuario a partir de un username 

    // Método para cambiar la password de un usuario 

    // Método para actualizar la foto de perfil del usuario

} // class