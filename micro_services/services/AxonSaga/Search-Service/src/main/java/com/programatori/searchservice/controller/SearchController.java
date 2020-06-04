package com.programatori.searchservice.controller;

import com.programatori.searchservice.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class SearchController {

    @Autowired
    SearchRepository searchRepository;

    @GetMapping("/hello")
    public ResponseEntity<?> get(@RequestParam("place") String place,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) throws UnknownHostException, ParseException {

        Date f = new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(fromDate);
        Date t = new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(toDate);

        return new ResponseEntity<>(searchRepository.getBySearchParams(place,f,t), HttpStatus.OK);
    }
}
