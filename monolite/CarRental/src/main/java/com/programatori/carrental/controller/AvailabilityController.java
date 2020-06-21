package com.programatori.carrental.controller;

import com.programatori.carrental.dto.AvailabilityDTO;
import com.programatori.carrental.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("availability")
public class AvailabilityController {

    @Autowired
    AvailabilityService availabilityService;


    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> putReservationToVehicle(@PathVariable Long id, @RequestBody AvailabilityDTO availabilityDTO) throws ParseException {

        return availabilityService.addReservation(id,availabilityDTO);

    }
}
