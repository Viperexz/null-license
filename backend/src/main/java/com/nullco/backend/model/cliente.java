package com.nullco.backend.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class cliente {
    @Id
    private long idNitCliente;
    private String nombreCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private String emailCliente;
    private LocalDate fechaRegistroCliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL , orphanRemoval = true ,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<servicio> servicios;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL , orphanRemoval = true ,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<pago> pagos;


}
