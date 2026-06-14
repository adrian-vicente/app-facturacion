package com.gestion.facturacion.backend.config;

public class ValidatorConfig {

    // Declaración de método para validar un identificador 

    public static boolean validarIdentificador(Long id) {
        return id >= 1;
    }

}