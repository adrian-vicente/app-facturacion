package com.gestion.facturacion.backend.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.gestion.facturacion.backend.model.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    // Declaración de variables inyectadas

    @Value("{${jwt.secret}}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    // Método para obtener la clave 

    private SecretKey obtenerClave() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Método para generar token 

    public String generarToken(Usuario usuario) {
        return Jwts.builder()
            .subject(usuario.getEmail())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(obtenerClave())
            .compact();
    }

} // class