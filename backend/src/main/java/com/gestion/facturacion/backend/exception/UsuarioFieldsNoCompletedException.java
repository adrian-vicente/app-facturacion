package com.gestion.facturacion.backend.exception;

public class UsuarioFieldsNoCompletedException extends RuntimeException {

    public UsuarioFieldsNoCompletedException(String mensaje) {
        super(mensaje);
    }

}
