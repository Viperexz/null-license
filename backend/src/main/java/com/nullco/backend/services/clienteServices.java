package com.nullco.backend.services;

import com.nullco.backend.model.cliente;
import com.nullco.backend.repository.clienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clienteServices {

    private final clienteInterface clienteRepository;

    public clienteServices(clienteInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Add methods to interact with clienteRepository as needed
    public cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<cliente> findAll() {
        return clienteRepository.findAll();
    }

    public cliente save(cliente cliente) {
        if (clienteRepository.existsById(cliente.getIdNitCliente())) {
            throw new IllegalArgumentException("El cliente con ID " + cliente.getIdNitCliente() + " ya existe.");
        }
        return clienteRepository.save(cliente);
    }

    public cliente update(cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }


}
