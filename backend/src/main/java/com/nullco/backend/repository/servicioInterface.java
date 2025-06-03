package com.nullco.backend.repository;

import com.nullco.backend.model.servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface servicioInterface extends JpaRepository<servicio, Long> {
}
