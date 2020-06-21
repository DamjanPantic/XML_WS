package com.programatori.carrental.service.impl;

import com.programatori.carrental.dto.AvailabilityDTO;
import com.programatori.carrental.dto.VehicleDTO;
import com.programatori.carrental.models.Availability;
import com.programatori.carrental.models.Image;
import com.programatori.carrental.models.User;
import com.programatori.carrental.models.Vehicle;
import com.programatori.carrental.repository.UserRepository;
import com.programatori.carrental.repository.VehicleRepository;
import com.programatori.carrental.service.AdService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    UserRepository userRepository;

    DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public ResponseEntity<?> newVehicle(VehicleDTO vehicleDTO) throws ParseException {

        User user = userRepository.findByEmail(vehicleDTO.getOwner().getEmail());

        Set<AvailabilityDTO> availabilityDTOS = vehicleDTO.getAvailabilities();
        vehicleDTO.setAvailabilities(null);

        Vehicle vehicle = mapper.map(vehicleDTO, Vehicle.class);

        if (availabilityDTOS != null){
            Set<Availability> availabilities = new HashSet<>();
            for (AvailabilityDTO availabilityDTO: availabilityDTOS){
                Availability availability = new Availability();
                availability.setFromDate(new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(availabilityDTO.getFromDate()));
                availability.setToDate(new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(availabilityDTO.getToDate()));
                availability.setPlace(availabilityDTO.getPlace());
                availability.setVehicle(vehicle);
                availabilities.add(availability);
            }
            vehicle.setAvailabilities(availabilities);
        }

        if (vehicle.getImages() != null){
            for(Image i : vehicle.getImages()){
                i.setVehicle(vehicle);
            }
        }
        vehicleRepository.save(vehicle);

        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for(Vehicle v : vehicleRepository.findAllByOwner(user)){
            vehicleDTOS.add(mapper.map(v,VehicleDTO.class));
        }

        return new ResponseEntity<>(vehicleDTOS, HttpStatus.OK);
    }
}
