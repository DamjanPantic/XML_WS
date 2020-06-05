package com.programatori.searchservice.controller;

import com.programatori.searchservice.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class SearchController {

    @Autowired
    SearchRepository searchRepository;

    @GetMapping("/hello")
    public ResponseEntity<?> get(@RequestParam("place") String place,
                                 @RequestParam("fromDate") String fromDate,
                                 @RequestParam("toDate") String toDate,
                                 @RequestParam("brand") String brand,
                                 @RequestParam("models") String models,
                                 @RequestParam("features") String features) throws ParseException {

        List<String> carModels = models == ""? null: Arrays.asList(models.split(","));

        System.out.println(carModels);

        Date f = new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(fromDate);
        Date t = new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(toDate);
        String b = brand == "" ? null : brand;

        return new ResponseEntity<>(searchRepository.getBySearchParams(place, f, t, b,carModels), HttpStatus.OK);
    }
}
