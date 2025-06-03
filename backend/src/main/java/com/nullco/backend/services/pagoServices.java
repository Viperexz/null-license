package com.nullco.backend.services;

import com.nullco.backend.model.pago;
import com.nullco.backend.repository.pagoInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pagoServices {
    
    private final pagoInterface pagoRepository;
    
    public pagoServices(pagoInterface pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public pago findById(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public List<pago> findAll() {
        return pagoRepository.findAll();
    }

    public pago save(pago pago) {
        if (pagoRepository.existsById(pago.getIdPago())) {
            throw new IllegalArgumentException("El pago con ID " + pago.getIdPago() + " ya existe.");
        }
        return pagoRepository.save(pago);
    }

    public pago update(pago pago) {
        return pagoRepository.save(pago);
    }

    public void deleteById(Long id) {
        pagoRepository.deleteById(id);
    }
    
}
