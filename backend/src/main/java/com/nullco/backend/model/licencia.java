package com.nullco.backend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
public class licencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLicencia;
    private String valueLicencia;
    private boolean estadoLicencia;
    private LocalDate fechaRegistroLicencia;

    @OneToOne
    @JsonBackReference
    private cliente cliente;

    @OneToOne
    @JsonBackReference
    private servicio servicio;
}
