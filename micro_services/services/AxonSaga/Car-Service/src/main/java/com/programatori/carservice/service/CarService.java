package com.programatori.carservice.service;

import org.springframework.http.ResponseEntity;

import java.security.NoSuchAlgorithmException;

public interface CarService {

    public String generateToken(Long id) throws NoSuchAlgorithmException;
    public Long getVehicleFromToken(String token);
    public ResponseEntity<?> getVehicleById(Long id);

}
