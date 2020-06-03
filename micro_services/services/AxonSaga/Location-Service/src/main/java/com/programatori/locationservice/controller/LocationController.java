package com.programatori.locationservice.controller;

import com.programatori.locationservice.models.LocationEntry;
import com.programatori.locationservice.service.ILocationEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class LocationController {

    @Autowired
    ILocationEntryService locationEntryService;

    @GetMapping("/hello")
    public ResponseEntity<?> get() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        return new ResponseEntity<>(String.format("Hello from Location service with ip address %s!", ip), HttpStatus.OK);
    }

    @RequestMapping(value = "/entries/{token}",method = RequestMethod.POST)
    public ResponseEntity<Boolean> addEntry( @RequestBody LocationEntry locationEntry, @PathVariable String token){
        Boolean ret = locationEntryService.insertLocationEntry(locationEntry, token);
        if(ret == true){
            return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
