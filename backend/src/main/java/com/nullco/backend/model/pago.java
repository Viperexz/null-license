package com.nullco.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class pago {
    @Id
    private long idPago;
    private LocalDate fechaRegistroPago;
    private double montoPago;
    private String metodoPago;

    @ManyToOne
    @JsonBackReference
    private cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    @JsonBackReference
    private servicio servicio;
}
