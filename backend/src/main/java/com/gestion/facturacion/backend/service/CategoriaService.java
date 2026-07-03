package com.gestion.facturacion.backend.service;

import org.springframework.stereotype.Service;

import com.gestion.facturacion.backend.config.ValidatorConfig;
import com.gestion.facturacion.backend.dto.Categoria.CategoriaDTO;
import com.gestion.facturacion.backend.model.Categoria;
import com.gestion.facturacion.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

    // Inyección de dependencias 

    private final CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Método de conversión: DTO ==> ENTITY

    public Categoria toEntity(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();

        if(ValidatorConfig.validarIdentificador(categoriaDTO.getId())) {
            categoria.setId(categoriaDTO.getId());
        }

        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setDescripcion(categoriaDTO.getDescripcion());

        return categoria;
    }

    // Método de conversión: ENTITY ==> DTO

    public CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();

        if(ValidatorConfig.validarIdentificador(categoria.getId())) {
            categoriaDTO.setId(categoria.getId());
        }

        categoriaDTO.setNombre(categoria.getNombre());
        categoriaDTO.setDescripcion(categoria.getDescripcion());

        return categoriaDTO;

    }

} // class