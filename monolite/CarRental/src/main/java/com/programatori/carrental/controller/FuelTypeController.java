package com.programatori.carrental.controller;

import com.programatori.carrental.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fuel-type")
public class FuelTypeController {

    @Autowired
    FuelTypeService fuelTypeService;

    @GetMapping(path = "",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getManufacturers(){

        return fuelTypeService.getFuelTypes();
    }
}
