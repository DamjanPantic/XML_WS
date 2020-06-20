package com.programatori.carrental.controller;

import com.programatori.carrental.service.TransmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transmission")
public class TransmissionController {

    @Autowired
    TransmissionService transmissionService;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getManufacturers(){

        return transmissionService.getTransmissions();
    }
}
