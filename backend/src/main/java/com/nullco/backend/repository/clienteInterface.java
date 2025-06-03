package com.nullco.backend.repository;

import com.nullco.backend.model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteInterface extends JpaRepository<cliente, Long> {
}
