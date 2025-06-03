package com.nullco.backend.repository;

import com.nullco.backend.model.pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pagoInterface extends JpaRepository<pago, Long> {
}
