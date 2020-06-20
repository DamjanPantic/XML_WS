package com.programatori.carrental.controller;

import com.programatori.carrental.dto.VehicleDTO;
import com.programatori.carrental.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping("ad")
public class AdController {

    @Autowired
    AdService adService;

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> newVehicles(@RequestBody VehicleDTO vehicleDTO) throws ParseException {

        return new ResponseEntity<>(adService.newVehicle(vehicleDTO), HttpStatus.OK);

    }
}
