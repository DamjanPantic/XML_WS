package com.programatori.carservice.service.impl;

import com.programatori.carservice.models.Vehicle;
import com.programatori.carservice.repository.VehicleRepository;
import com.programatori.carservice.service.CarService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public String generateToken(Long id) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(id.toString().getBytes(StandardCharsets.UTF_8));
        BigInteger number = new BigInteger(1,hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));

        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        String token = hexString.toString();

        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        if (vehicle == null){
            return null;
        }

        vehicle.setCarToken(token);
        vehicleRepository.save(vehicle);

        return token;
    }

    @Override
    public Long getVehicleFromToken(String token) {
        Vehicle vehicle = vehicleRepository.findByCarToken(token);
        if (vehicle == null){
            return null;
        }
        return vehicle.getId();
    }

    @Override
    public ResponseEntity<?> getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findOneById(id);
        if(vehicle == null)
            return new ResponseEntity<>("Vehicle with that ID dont exist", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }
}
