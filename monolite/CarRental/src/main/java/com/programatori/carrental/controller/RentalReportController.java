package com.programatori.carrental.controller;

import com.programatori.carrental.dto.RentalReportDTO;
import com.programatori.carrental.service.RentalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reports")
public class RentalReportController {

    @Autowired
    RentalReportService rentalReportService;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getManufacturers(){
        return new ResponseEntity<String>("hello", HttpStatus.OK);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addReport(@RequestBody  RentalReportDTO rentalReportDTO){
        com.programatori.carrental.models.RentalReport rentalReport = rentalReportService.insertReport(rentalReportDTO);
        if(rentalReport == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(rentalReport,HttpStatus.OK);
    }
}
