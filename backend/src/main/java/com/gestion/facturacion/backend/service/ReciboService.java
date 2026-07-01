package com.gestion.facturacion.backend.service;

import org.springframework.stereotype.Service;

import com.gestion.facturacion.backend.config.ValidatorConfig;
import com.gestion.facturacion.backend.dto.ReciboDTO;
import com.gestion.facturacion.backend.model.Recibo;
import com.gestion.facturacion.backend.repository.ReciboRepository;

@Service
public class ReciboService {

    // Inyección de dependencias

    private final ReciboRepository reciboRepository;
    public ReciboService(ReciboRepository reciboRepository) {
        this.reciboRepository = reciboRepository;
    }

    // Método de conversión: DTO ==> ENTITY

    public Recibo toEntity(ReciboDTO reciboDTO) {
        Recibo recibo = new Recibo();

        if(ValidatorConfig.validarIdentificador(reciboDTO.getId())) {
            recibo.setId(reciboDTO.getId());
        }

        recibo.setNombreArchivo(reciboDTO.getNombreArchivo());
        recibo.setRutaArchivo(reciboDTO.getRutaArchivo());

        // Devolver el objeto con los datos obtenidos

        return recibo;

    }

    // Método de conversión: ENTITY ==> DTO

    public ReciboDTO toDTO(Recibo recibo) {
        ReciboDTO reciboDTO = new ReciboDTO();

        if(ValidatorConfig.validarIdentificador(recibo.getId())) {
            reciboDTO.setId(recibo.getId());
        }

        reciboDTO.setNombreArchivo(recibo.getNombreArchivo());
        reciboDTO.setRutaArchivo(recibo.getRutaArchivo());

        // Devolver el objeto con los datos obtenidos

        return reciboDTO;

    }

} // class