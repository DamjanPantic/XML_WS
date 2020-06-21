package com.programatori.carrental.controller;

import com.programatori.carrental.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("model")
public class ModelController {

    @Autowired
    ModelService modelService;

    @GetMapping(path = "/{manufacturerName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getManufacturers(@PathVariable String manufacturerName){

        return modelService.getModelsByManufacturer(manufacturerName);
    }
}
