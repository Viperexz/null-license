package com.nullco.backend.repository;

import com.nullco.backend.model.licencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface licenciaInterface extends JpaRepository<licencia, Long> {
}
