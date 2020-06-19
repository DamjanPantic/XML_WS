package com.programatori.searchservice.controller;

import com.programatori.searchservice.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/")
    public ResponseEntity<?> search(@RequestParam("place") String place,
                                 @RequestParam("fromDate") String fromDate,
                                 @RequestParam("toDate") String toDate,
                                 @RequestParam("brand") String brand,
                                 @RequestParam("models") String models,
                                 @RequestParam("fuel") String fuel,
                                 @RequestParam("transmission") String transmission,
                                 @RequestParam("vehicleType") String vehicleType,
                                 @RequestParam("page") Integer pageNo) throws ParseException {
        return new ResponseEntity<>(searchService.searchVehicleByParams(place, fromDate, toDate, brand, models,fuel,
                transmission,vehicleType,pageNo),
                HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam("pageNo") Integer pageNo){
        return new ResponseEntity<>(searchService.getVehicles(pageNo), HttpStatus.OK);
    }
}
