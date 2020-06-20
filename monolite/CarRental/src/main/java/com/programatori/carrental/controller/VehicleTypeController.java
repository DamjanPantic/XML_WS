package com.programatori.carrental.controller;

import com.programatori.carrental.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vehicle-type")
public class VehicleTypeController {

    @Autowired
    VehicleTypeService vehicleTypeService;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getManufacturers(){

        return vehicleTypeService.getVehicleTypes();
    }
}
