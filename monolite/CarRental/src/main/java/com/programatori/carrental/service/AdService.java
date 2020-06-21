package com.programatori.carrental.service;

import com.programatori.carrental.dto.VehicleDTO;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface AdService {
    public ResponseEntity<?> newVehicle(VehicleDTO vehicleDTO) throws ParseException;
}
