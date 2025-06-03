package com.nullco.backend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idServicio;
    private String nombreServicio;
    private String descripcionServicio;
    private double precioServicio;
    private LocalDate fechaRegistroServicio;
    private boolean estadoServicio;

    private boolean pruebaServicio;
    private LocalDate fechaRegistroPruebaServicio;


    @OneToOne
    @JoinColumn(name = "licencia_id")
    @JsonManagedReference
    private licencia licencia;

    @OneToMany(mappedBy = "servicio",cascade = CascadeType.ALL , orphanRemoval = true ,fetch = FetchType.LAZY)
    private List<pago> pagos;
}
