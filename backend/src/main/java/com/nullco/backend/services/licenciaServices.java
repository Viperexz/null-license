package com.nullco.backend.services;

import com.nullco.backend.model.licencia;
import com.nullco.backend.repository.licenciaInterface;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

@Service
public class licenciaServices {

    private final licenciaInterface licenciaRepository;

    licenciaServices (licenciaInterface licenciaRepository) {
        this.licenciaRepository = licenciaRepository;
    }

    // Add methods to interact with licenciaRepository as needed
    public licencia findById(Long id) {
        return licenciaRepository.findById(id).orElse(null);
    }

    public List<licencia> findAll() {
        return licenciaRepository.findAll();
    }

    public licencia save(licencia licencia) {
        if (licenciaRepository.existsById(licencia.getIdLicencia())) {
            throw new IllegalArgumentException("El licencia con ID " + licencia.getIdLicencia() + " ya existe.");
        }
        licencia.setValueLicencia(generateLicencia(licencia));
        return licenciaRepository.save(licencia);
    }

    public licencia update(licencia licencia) {
        return licenciaRepository.save(licencia);
    }

    public void deleteById(Long id) {
        licenciaRepository.deleteById(id);
    }

    public String generateLicencia(licencia licencia) {
        long idServicio = licencia.getServicio().getIdServicio();
        LocalDate fechaServicio = licencia.getServicio().getFechaRegistroServicio();
        long idCliente = licencia.getCliente().getIdNitCliente();

        String rawData = idServicio + "-" + fechaServicio + "-" + idCliente;
        String hashed = hashText(rawData);

        licencia.setValueLicencia(hashed);
        return hashed;
    }

    private String hashText(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generando hash para licencia", e);
        }
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    private boolean isValidLicencia(licencia licencia, String valueLicencia) {
        return generateLicencia(licencia).equals(valueLicencia);// Placeholder for actual validation logic
    }

    
}
