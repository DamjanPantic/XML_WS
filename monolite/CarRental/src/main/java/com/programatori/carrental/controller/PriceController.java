package com.programatori.carrental.controller;

import com.programatori.carrental.dto.PriceTypeDTO;
import com.programatori.carrental.service.ModelService;
import com.programatori.carrental.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("price")
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping(path = "/type", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getManufacturers(){
        List<PriceTypeDTO> priceTypeDTOS = priceService.getAllPriceTypes();
        return new ResponseEntity<>(priceTypeDTOS, HttpStatus.OK);
    }
}
