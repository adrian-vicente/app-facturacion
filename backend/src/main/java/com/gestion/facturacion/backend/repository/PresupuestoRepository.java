package com.gestion.facturacion.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.facturacion.backend.model.Presupuesto;

@Repository
public interface PresupuestoRepository extends JpaRepository<Presupuesto, Long> {

}
