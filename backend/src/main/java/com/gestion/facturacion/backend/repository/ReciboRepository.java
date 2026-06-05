package com.gestion.facturacion.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.facturacion.backend.model.Recibo;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long> {

}
