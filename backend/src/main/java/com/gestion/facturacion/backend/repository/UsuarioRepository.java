package com.gestion.facturacion.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.facturacion.backend.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Obtener usuario a partir del username

    public Optional<Usuario> findByNombre(String nombre);

    // Comprobar si el username ya existe
    public boolean existsByNombre(String nombre);

    // Comprobar si el email ya existe

    public boolean existsByEmail(String email);

    // Obtener usuario a partir del email 

    public Optional<Usuario> findByEmail(String email);

}