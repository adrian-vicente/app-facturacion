package com.gestion.facturacion.backend.exception;

public class UsuarioAlreadyExistsException extends RuntimeException {

    public UsuarioAlreadyExistsException(String mensaje) {
        super(mensaje);
    }

}
