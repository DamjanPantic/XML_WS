package com.programatori.carrental.controller;

import com.programatori.carrental.models.Image;
import com.programatori.carrental.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    @Autowired
    ImageRepository imageRepository;

    @GetMapping(path = "/{vehicleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getManufacturers(@PathVariable Long vehicleId){

        List<Image> images = imageRepository.findAllByVehicleId(vehicleId);

        return new ResponseEntity<>(images, HttpStatus.OK);
    }
}
