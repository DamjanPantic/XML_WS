package com.programatori.carservice.service;

import com.programatori.carservice.dto.VehicleDTO;

import java.text.ParseException;
import java.util.List;

public interface AdService {
    public List<VehicleDTO> newVehicle(VehicleDTO vehicleDTO) throws ParseException;

}
