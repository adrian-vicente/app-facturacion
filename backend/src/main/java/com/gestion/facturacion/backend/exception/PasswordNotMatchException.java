package com.gestion.facturacion.backend.exception;

public class PasswordNotMatchException extends RuntimeException {

    public PasswordNotMatchException(String mensaje) {
        super(mensaje);
    }

}
