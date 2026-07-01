package com.gestion.facturacion.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestion.facturacion.backend.config.ValidatorConfig;
import com.gestion.facturacion.backend.dto.UsuarioDTO;
import com.gestion.facturacion.backend.exception.UsuarioEmptyException;
import com.gestion.facturacion.backend.exception.UsuarioFieldsNoCompletedException;
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

    // Método para crear un nuevo usuario

    public Long crearUsuario(UsuarioDTO usuarioDTO) throws Exception {
    
        // Validar que el usuario pasado por parámetro no es nulo

        if(ValidatorConfig.validarObjeto(usuarioDTO)) throw new UsuarioEmptyException("No se puede crear un usuario que no tiene datos añadidos.");

        // Validar que tenga los campos rellenados 
        
        if(!camposRellenados(usuarioDTO)) throw new UsuarioFieldsNoCompletedException("Los campos del usuario deben estar rellenados para poder crearlo.");

        // Validar el formato del correo electrónico 

        // Validar la longitud y complejidad de la password 

        // Validar que no exista el nombre de usuario previamente 

        // Normalizar los datos para evitar errores al guardarlo en la base de datos 

        // Comprobar que el email no esté registrado previamente 

        // Cifrar la password antes de guardarla en la base de datos 

        // Asignar valores / roles por defecto del usuario 

        // Devolver el identificador del usuario creado o el token en función del sistema implementado

        return 0L;

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

    // Método para validar que los campos del usuario estén rellenados 

    public boolean camposRellenados(UsuarioDTO usuarioDTO) {
        if(usuarioDTO.getNombre().length() >= 1 && usuarioDTO.getPassword().length() >= 1 && usuarioDTO.getEmail().length() >= 1) return true;
        else return false;

    }

} // class