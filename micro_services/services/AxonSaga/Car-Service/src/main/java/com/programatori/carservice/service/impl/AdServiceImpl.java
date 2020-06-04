package com.programatori.carservice.service.impl;

import com.programatori.carservice.dto.AvailabilityDTO;
import com.programatori.carservice.dto.VehicleDTO;
import com.programatori.carservice.models.Availability;
import com.programatori.carservice.models.User;
import com.programatori.carservice.models.Vehicle;
import com.programatori.carservice.repository.FeatureValueRepository;
import com.programatori.carservice.repository.UserRepository;
import com.programatori.carservice.repository.VehicleRepository;
import com.programatori.carservice.service.AdService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    FeatureValueRepository featureValueRepository;

    DozerBeanMapper mapper = new DozerBeanMapper();


    @Override
    public List<VehicleDTO> newVehicle(VehicleDTO vehicleDTO) throws ParseException {

        User user = userRepository.findByEmail(vehicleDTO.getOwner().getEmail());

        if(vehicleRepository.findAllByOwner(user).size() >= 3){
            return null;
        }

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

        vehicleRepository.save(vehicle);

        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for(Vehicle v : vehicleRepository.findAllByOwner(user)){
            vehicleDTOS.add(mapper.map(v,VehicleDTO.class));
        }
        return vehicleDTOS;

    }

}
