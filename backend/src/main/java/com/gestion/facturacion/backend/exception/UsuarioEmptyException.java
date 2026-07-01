package com.gestion.facturacion.backend.exception;

public class UsuarioEmptyException extends RuntimeException {

    public UsuarioEmptyException(String mensaje) {
        super(mensaje);
    }
    
}
