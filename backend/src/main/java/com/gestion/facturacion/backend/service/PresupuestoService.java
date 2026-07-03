package com.gestion.facturacion.backend.service;

import org.springframework.stereotype.Service;

import com.gestion.facturacion.backend.config.ValidatorConfig;
import com.gestion.facturacion.backend.dto.Presupuesto.PresupuestoDTO;
import com.gestion.facturacion.backend.exception.CategoriaNotFoundException;
import com.gestion.facturacion.backend.exception.UsuarioNotFoundException;
import com.gestion.facturacion.backend.model.Categoria;
import com.gestion.facturacion.backend.model.Presupuesto;
import com.gestion.facturacion.backend.model.Usuario;
import com.gestion.facturacion.backend.repository.CategoriaRepository;
import com.gestion.facturacion.backend.repository.PresupuestoRepository;
import com.gestion.facturacion.backend.repository.UsuarioRepository;

@Service
public class PresupuestoService {

    // Inyección de dependencias 

    private final PresupuestoRepository presupuestoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;

    public PresupuestoService(PresupuestoRepository presupuestoRepository, UsuarioRepository usuarioRepository, CategoriaRepository categoriaRepository) {
        this.presupuestoRepository = presupuestoRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;

    }

    // Método de conversión: DTO ==> ENTITY

    public Presupuesto toEntity(PresupuestoDTO presupuestoDTO) {
        Presupuesto presupuesto = new Presupuesto();

        if(ValidatorConfig.validarIdentificador(presupuestoDTO.getId())) {
            presupuesto.setId(presupuestoDTO.getId());

        }

        presupuesto.setLimite(presupuestoDTO.getLimite());
        presupuesto.setPeriodo(presupuestoDTO.getPeriodo());

        // Obtener el usuario (Entitdad)
 
       Usuario usuario = usuarioRepository.findById(presupuestoDTO.getUsuario_id())
            .orElseThrow(() -> new UsuarioNotFoundException("No se ha encontrado ningún usuario con id: " + presupuestoDTO.getUsuario_id()));

        presupuesto.setUsuario(usuario);

        // Obtener la categoría (Entidad)

        Categoria categoria = categoriaRepository.findById(presupuestoDTO.getCategoria_id())
            .orElseThrow(() -> new CategoriaNotFoundException("No se ha encontrado ninguna categoría con id: " + presupuestoDTO.getCategoria_id()));

        presupuesto.setCategoria(categoria);

        // Devolver el objeto con los datos obtenidos 

        return presupuesto;

    }

    // Método de conversión: ENTITY ==> DTO

    public PresupuestoDTO toDTO(Presupuesto presupuesto) {
        PresupuestoDTO presupuestoDTO = new PresupuestoDTO();

        if(ValidatorConfig.validarIdentificador(presupuesto.getId())) {
            presupuestoDTO.setId(presupuesto.getId());

        }

        presupuestoDTO.setLimite(presupuesto.getLimite());
        presupuestoDTO.setPeriodo(presupuesto.getPeriodo());

        // Obtener el identificador del usuario y categoría 

        if(presupuesto.getUsuario() != null) presupuestoDTO.setUsuario_id(presupuesto.getUsuario().getId());
        if(presupuesto.getCategoria() != null) presupuestoDTO.setCategoria_id(presupuesto.getCategoria().getId());
        
        // Devolver el objeto con los datos obtenidos

        return presupuestoDTO;
        
    }

} // class