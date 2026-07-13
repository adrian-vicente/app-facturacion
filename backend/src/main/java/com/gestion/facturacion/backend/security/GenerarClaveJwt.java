package com.gestion.facturacion.backend.security;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;

public class GenerarClaveJwt {

    // MÉTODO QUE SOLO SIRVE PARA GENERAR LA CLAVE PRIVADA (NO UTILIZAR EN PRODUCCIÓN)
    // GENERA UNA CLAVE Y SE COPIA EN APPLICATION.PROPERTIES (EN PRODUCCIÓN SERVICIO AWS RECOMENDADO PARA TOKENS)
    // CLICK DERECHO -> EJECUTAR CÓMO PROGRAMA JAVA

    public static void main(String[] args) {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String clave = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("Clave privada generada: " + clave);
        
    }

} // class