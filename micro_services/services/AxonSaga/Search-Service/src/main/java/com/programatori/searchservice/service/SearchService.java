package com.programatori.searchservice.service;

import com.programatori.searchservice.models.Vehicle;
import org.springframework.data.domain.Page;

import java.text.ParseException;

public interface SearchService {
    public Page<Vehicle> searchVehicleByParams(String place, String fromDate, String toDate, String brand,
                                               String models, String fuel, String transmission, String vehicleType,
                                               Integer pageNo) throws ParseException;
    public Page<Vehicle> getVehicles(Integer pageNo);

}
