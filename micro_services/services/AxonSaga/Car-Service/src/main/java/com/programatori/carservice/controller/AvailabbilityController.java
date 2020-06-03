package com.programatori.carservice.controller;

import com.programatori.carservice.dto.AvailabilityDTO;
import com.programatori.carservice.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Set;

@RestController
@RequestMapping(value = "/availability")
public class AvailabbilityController {

    @Autowired
    AvailabilityService availabilityService;

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addAvailabilityToVehicle(@PathVariable Long id, @RequestBody AvailabilityDTO availabilityDTO) throws ParseException {

        Set<AvailabilityDTO> availabilitiesDTO = availabilityService.addAvailability(id, availabilityDTO);
        if (availabilitiesDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(availabilitiesDTO, HttpStatus.OK);

    }
}
