package com.gestion.facturacion.backend.exception;

public class CategoriaNotFoundException extends RuntimeException {
    
    public CategoriaNotFoundException(String mensaje) {
        super(mensaje);
    }

}
