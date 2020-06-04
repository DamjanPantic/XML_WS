package com.programatori.carservice.controller;

import com.programatori.carservice.dto.VehicleDTO;
import com.programatori.carservice.models.Vehicle;
import com.programatori.carservice.repository.VehicleRepository;
import com.programatori.carservice.service.AdService;
import com.programatori.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    AdService adService;

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/hello")
    public ResponseEntity<?> get() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        return new ResponseEntity<>(String.format("Hello from Car service with ip address %s!", ip), HttpStatus.OK);
    }

    @RequestMapping(value = "/token/{id}",method = RequestMethod.POST)
    public ResponseEntity<?> getVehiclesToken(@PathVariable Long id) throws NoSuchAlgorithmException {
        String token = carService.generateToken(id);
        if (token == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @RequestMapping(value = "/token/{token}",method = RequestMethod.GET)
    public ResponseEntity<?> getTokensVehicle(@PathVariable String token) throws NoSuchAlgorithmException {
        Long vehicle = carService.getVehicleFromToken(token);
        if (vehicle == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTokensVehicle(@RequestBody VehicleDTO vehicleDTO) throws NoSuchAlgorithmException {

        List<VehicleDTO> vehicleDTOS = adService.newVehicle(vehicleDTO);
        if (vehicleDTOS == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(vehicleDTOS, HttpStatus.OK);

    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public List<Vehicle> getVehicle() throws NoSuchAlgorithmException {

        return vehicleRepository.findAll();
    }


}
