package com.nullco.backend.services;

import com.nullco.backend.model.servicio;
import com.nullco.backend.repository.servicioInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class servicioServices {
    
    private final servicioInterface servicioRepository;

    public servicioServices(servicioInterface servicioRepository) {
        this.servicioRepository = servicioRepository;
    }
    
    public servicio findById(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public List<servicio> findAll() {
        return servicioRepository.findAll();
    }

    public servicio save(servicio servicio) {
        if (servicioRepository.existsById(servicio.getIdServicio())) {
            throw new IllegalArgumentException("El servicio con ID " + servicio.getIdServicio() + " ya existe.");
        }
        return servicioRepository.save(servicio);
    }

    public servicio update(servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public void deleteById(Long id) {
        servicioRepository.deleteById(id);
    }
}
