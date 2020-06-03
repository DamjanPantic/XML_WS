package com.programatori.carservice.service.impl;

import com.programatori.carservice.dto.AvailabilityDTO;
import com.programatori.carservice.models.Availability;
import com.programatori.carservice.models.Vehicle;
import com.programatori.carservice.repository.AvailabilityRepository;
import com.programatori.carservice.repository.VehicleRepository;
import com.programatori.carservice.service.AvailabilityService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    AvailabilityRepository availabilityRepository;

    DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public Set<AvailabilityDTO> addAvailability(Long id, AvailabilityDTO availabilityDTO) throws ParseException {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        if (vehicle == null){
            return null;
        }

        if (vehicle.getAvailabilities() == null){
            vehicle.setAvailabilities(new HashSet<>());
        }

        Availability availability = new Availability();
        availability.setPlace(availabilityDTO.getPlace());
        availability.setFromDate(new SimpleDateFormat("yyyy-MM-DD").parse(availabilityDTO.getFromDate()));
        availability.setToDate(new SimpleDateFormat("yyyy-MM-DD").parse(availabilityDTO.getToDate()));
        availability.setVehicle(vehicle);

        vehicle.getAvailabilities().add(availability);
        vehicleRepository.save(vehicle);

        return availabilityRepository.findByVehicleId(id);
    }

    @Override
    public Set<AvailabilityDTO> addReservation(Long id, AvailabilityDTO availabilityDTO) {
        return null;
    }
}
