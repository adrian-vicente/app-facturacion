package com.gestion.facturacion.backend.service;

import org.springframework.stereotype.Service;

import com.gestion.facturacion.backend.config.ValidatorConfig;
import com.gestion.facturacion.backend.dto.MovimientoDTO;
import com.gestion.facturacion.backend.exception.CategoriaNotFoundException;
import com.gestion.facturacion.backend.exception.UsuarioNotFoundException;
import com.gestion.facturacion.backend.model.Categoria;
import com.gestion.facturacion.backend.model.Movimiento;
import com.gestion.facturacion.backend.model.Usuario;
import com.gestion.facturacion.backend.repository.CategoriaRepository;
import com.gestion.facturacion.backend.repository.MovimientoRepository;
import com.gestion.facturacion.backend.repository.UsuarioRepository;

@Service
public class MovimientoService {

    // Inyección de dependencias 

    private final MovimientoRepository movimientoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;

    public MovimientoService(MovimientoRepository movimientoRepository, UsuarioRepository usuarioRepository, CategoriaRepository categoriaRepository) {
        this.movimientoRepository = movimientoRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;

    }

    // Método de conversión: DTO ==> ENTITY

    public Movimiento toEntity(MovimientoDTO movimientoDTO) {
       Movimiento movimiento = new Movimiento();
       
       if(ValidatorConfig.validarIdentificador(movimientoDTO.getId())) {
            movimiento.setId(movimientoDTO.getId());
       }

       movimiento.setConcepto(movimientoDTO.getConcepto());
       movimiento.setDescripcion(movimientoDTO.getDescripcion());
       movimiento.setImporte(movimientoDTO.getImporte());
       movimiento.setFecha(movimientoDTO.getFecha());
       movimiento.setTipoMovimiento(movimientoDTO.getTipoMovimiento());

       // Obtener atributos derivados de relaciones 
       
       Usuario usuarioMovimiento = usuarioRepository.findById(movimientoDTO.getUsuario_id())
            .orElseThrow(() -> new UsuarioNotFoundException("No se ha encontrado ningún usuario con id: " + movimientoDTO.getId()));

        movimiento.setUsuario(usuarioMovimiento);

       Categoria categoriaMovimiento = categoriaRepository.findById(movimientoDTO.getCategoria_id())
            .orElseThrow(() -> new CategoriaNotFoundException("No se ha encontrado ninguna categoría con id: " + movimientoDTO.getCategoria_id()));

        movimiento.setCategoria(categoriaMovimiento);

        // Devolver el objeto con los datos obtenidos y añadidos 

        return movimiento;

    }

    // Método de conversión: ENTITY ==> DTO

    public MovimientoDTO toDTO(Movimiento movimiento) {
        MovimientoDTO movimientoDTO = new MovimientoDTO();

        if(ValidatorConfig.validarIdentificador(movimiento.getId())) {
            movimientoDTO.setId(movimiento.getId());
        }

        movimientoDTO.setConcepto(movimiento.getConcepto());
        movimientoDTO.setDescripcion(movimiento.getDescripcion());
        movimientoDTO.setImporte(movimiento.getImporte());
        movimientoDTO.setFecha(movimiento.getFecha());
        movimientoDTO.setTipoMovimiento(movimiento.getTipoMovimiento());

        // Validar identificadores de objeto antes de añadirlos al DTO

        if(movimiento.getUsuario() != null && ValidatorConfig.validarIdentificador(movimiento.getUsuario().getId())) {
            movimientoDTO.setUsuario_id(movimiento.getUsuario().getId());
        }

        if(movimiento.getCategoria() != null && ValidatorConfig.validarIdentificador(movimiento.getCategoria().getId())) {
            movimientoDTO.setCategoria_id(movimiento.getCategoria().getId());
        }

        // Devolver el objeto con los datos obtenidos y añadidos 

        return movimientoDTO;

    }

}
