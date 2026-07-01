package com.gestion.facturacion.backend.config;

public class ValidatorConfig {

    // Declaración de método para validar un identificador 

    public static boolean validarIdentificador(Long id) {
        return id >= 1;
    }

    // Método que permite validar si un objeto es nulo o no 

    public static <T> boolean validarObjeto(T objeto) {
        return objeto != null;
    }

}