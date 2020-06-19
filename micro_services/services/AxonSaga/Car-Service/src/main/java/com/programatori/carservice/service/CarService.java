package com.programatori.carservice.service;

import com.programatori.carservice.dto.VehicleDTO;

import java.security.NoSuchAlgorithmException;

public interface CarService {

    public String generateToken(Long id) throws NoSuchAlgorithmException;
    public Long getVehicleFromToken(String token);

}
