package com.programatori.carservice.controller;

import com.programatori.carservice.dto.VehicleDTO;
import com.programatori.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/hello")
    public ResponseEntity<?> get() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        return new ResponseEntity<>(String.format("Hello from Car service with ip address %s!", ip), HttpStatus.OK);
    }

    @GetMapping("/token/{id}")
    public ResponseEntity<?> getVehiclesToken(@PathVariable Long id) throws NoSuchAlgorithmException {
        String token = carService.generateToken(id);
        if (token == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping("/token/{token}")
    public ResponseEntity<?> getTokensVehicle(@PathVariable String token) throws NoSuchAlgorithmException {
        VehicleDTO vehicle = carService.getVehicleFromToken(token);
        if (vehicle == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }
}
