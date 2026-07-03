package com.gestion.facturacion.backend.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String mensaje) {
        super(mensaje);
    }

}
