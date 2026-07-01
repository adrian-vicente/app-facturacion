package com.gestion.facturacion.backend.service;

import org.springframework.stereotype.Service;

import com.gestion.facturacion.backend.config.ValidatorConfig;
import com.gestion.facturacion.backend.dto.ObjetivoAhorroDTO;
import com.gestion.facturacion.backend.exception.UsuarioNotFoundException;
import com.gestion.facturacion.backend.model.ObjetivoAhorro;
import com.gestion.facturacion.backend.model.Usuario;
import com.gestion.facturacion.backend.repository.ObjetivoAhorroRepository;
import com.gestion.facturacion.backend.repository.UsuarioRepository;

@Service
public class ObjetivoAhorroService {

    // Inyección de dependencias 

    private final ObjetivoAhorroRepository objetivoAhorroRepository;
    private final UsuarioRepository usuarioRepository;

    public ObjetivoAhorroService(ObjetivoAhorroRepository objetivoAhorroRepository, UsuarioRepository usuarioRepository) {
        this.objetivoAhorroRepository = objetivoAhorroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Método de conversión: DTO ==> ENTITY

    public ObjetivoAhorro toEntity(ObjetivoAhorroDTO objetivoAhorroDTO) {
        ObjetivoAhorro objetivoAhorro = new ObjetivoAhorro();
        
        if(ValidatorConfig.validarIdentificador(objetivoAhorroDTO.getId())) {
            objetivoAhorro.setId(objetivoAhorroDTO.getId());
        }

        objetivoAhorro.setNombre(objetivoAhorroDTO.getNombre());
        objetivoAhorro.setObjetivo(objetivoAhorroDTO.getObjetivo());
        objetivoAhorro.setAhorrado(objetivoAhorroDTO.getAhorrado());
        
        // Obtener el usuario para la entidad
        
        Usuario u = usuarioRepository.findById(objetivoAhorroDTO.getUsuario_id())
            .orElseThrow(() -> new UsuarioNotFoundException("No se ha encontrado a ningún usuario con id: " + objetivoAhorroDTO.getUsuario_id()));
        
        objetivoAhorro.setUsuario(u);

        // Devolver el objeto con los datos obtenidos

        return objetivoAhorro;

    }

    // Método de conversión: ENTITY ==> DTO

    public ObjetivoAhorroDTO toDTO(ObjetivoAhorro objetivoAhorro) {
        ObjetivoAhorroDTO objetivoAhorroDTO = new ObjetivoAhorroDTO();

        if(ValidatorConfig.validarIdentificador(objetivoAhorro.getId())) {
            objetivoAhorroDTO.setId(objetivoAhorro.getId());    
        }

        objetivoAhorroDTO.setNombre(objetivoAhorro.getNombre());
        objetivoAhorroDTO.setObjetivo(objetivoAhorro.getObjetivo());
        objetivoAhorroDTO.setAhorrado(objetivoAhorro.getAhorrado());

        // Obtener el identificador del usuario 

        if(objetivoAhorro.getUsuario() != null) {
            objetivoAhorroDTO.setId(objetivoAhorro.getUsuario().getId());
        
        }

        // Devolver el objeto con los datos obtenidos

        return objetivoAhorroDTO;

    }

}