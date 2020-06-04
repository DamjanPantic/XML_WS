package com.programatori.carservice.service.impl;

import com.programatori.carservice.dto.VehicleDTO;
import com.programatori.carservice.models.Image;
import com.programatori.carservice.models.User;
import com.programatori.carservice.models.Vehicle;
import com.programatori.carservice.repository.FeatureValueRepository;
import com.programatori.carservice.repository.UserRepository;
import com.programatori.carservice.repository.VehicleRepository;
import com.programatori.carservice.service.AdService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<VehicleDTO> newVehicle(VehicleDTO vehicleDTO) {

        User user = userRepository.findByEmail(vehicleDTO.getOwner().getEmail());

        if(vehicleRepository.findAllByOwner(user).size() >= 3){
            return null;
        }
        Vehicle vehicle = mapper.map(vehicleDTO, Vehicle.class);
        for(Image i : vehicle.getImages()){
            i.setVehicle(vehicle);
        }
        vehicleRepository.save(vehicle);

        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for(Vehicle v : vehicleRepository.findAllByOwner(user)){
            vehicleDTOS.add(mapper.map(v,VehicleDTO.class));
        }
        return vehicleDTOS;

    }

}
