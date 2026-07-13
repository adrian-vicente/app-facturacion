package com.gestion.facturacion.backend.exception;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Excepción cuándo no se encuentra un usuario

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<String> usuarioNotFound(UsuarioNotFoundException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.getMessage());
            
    }

    // Excepción cuándo no se encuentra una categoría

    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<String> categoriaNotFound(CategoriaNotFoundException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.getMessage());
    }

    // Excepción cuándo se manda a crear un usuario nulo

    @ExceptionHandler(UsuarioEmptyException.class)
    public ResponseEntity<String> usuarioNoExiste(UsuarioEmptyException ex) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ex.getMessage());
            
    }

    // Excepción cuándo los campos de un usuario están vacíos 

    @ExceptionHandler(UsuarioFieldsNoCompletedException.class)
    public ResponseEntity<String> usuarioFieldsNoCompleted(UsuarioFieldsNoCompletedException ex) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ex.getMessage());
    }

    // Excepción cuándo el nombre de usuario ya existe en la base de datos 

    @ExceptionHandler(UsuarioAlreadyExistsException.class)
    public ResponseEntity<String> usuarioAlreadyExists(UsuarioAlreadyExistsException ex) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(ex.getMessage());
            
    }

    // Excepción cuándo existe email

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> emailAlreadyExists(EmailAlreadyExistsException ex) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(ex.getMessage());
    }

    // Excepción cuándo la password no coincide 

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<String> passwordNotMatch(PasswordNotMatchException ex) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ex.getMessage());
    }

}
