package com.programatori.carservice.service.impl;

import com.programatori.carservice.dto.AvailabilityDTO;
import com.programatori.carservice.models.Availability;
import com.programatori.carservice.models.Vehicle;
import com.programatori.carservice.repository.AvailabilityRepository;
import com.programatori.carservice.repository.VehicleRepository;
import com.programatori.carservice.service.AvailabilityService;
import org.apache.commons.lang3.time.DateUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        if (vehicle == null) {
            return null;
        }

        if (vehicle.getAvailabilities() == null) {
            vehicle.setAvailabilities(new HashSet<>());
        }

        Availability availability = new Availability();
        availability.setPlace(availabilityDTO.getPlace());

        Date formDate = new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(availabilityDTO.getFromDate());
        Date toDate = new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(availabilityDTO.getToDate());

        availability.setFromDate(formDate);
        availability.setToDate(toDate);
        availability.setVehicle(vehicle);

        vehicle.getAvailabilities().add(availability);
        vehicleRepository.save(vehicle);

        return availabilityRepository.findByVehicleId(id);
    }

    @Override
    public Set<AvailabilityDTO> addReservation(Long id, AvailabilityDTO availabilityDTO) throws ParseException {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        if (vehicle == null) {
            return null;
        }

        if (vehicle.getAvailabilities() == null) {
            return null;
        }

        Date fromDate = new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(availabilityDTO.getFromDate());
        Date toDate = new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(availabilityDTO.getToDate());

        for (Availability availability : vehicle.getAvailabilities()) {
            if (fromDate.compareTo(availability.getFromDate()) >= 0
                    && toDate.compareTo(availability.getToDate()) <= 0) {

                fromDate = DateUtils.addMinutes(fromDate, -1);
                toDate = DateUtils.addMinutes(toDate, 1);

                if (fromDate.compareTo(availability.getFromDate()) >= 0){
                    Availability newAvailability = new Availability();
                    newAvailability.setPlace(availability.getPlace());
                    newAvailability.setFromDate(availability.getFromDate());
                    newAvailability.setToDate(fromDate);
                    newAvailability.setVehicle(vehicle);
                    vehicle.getAvailabilities().add(newAvailability);
                }

                if (toDate.compareTo(availability.getToDate()) <= 0){
                    Availability newAvailability = new Availability();
                    newAvailability.setPlace(availability.getPlace());
                    newAvailability.setFromDate(toDate);
                    newAvailability.setToDate(availability.getToDate());
                    newAvailability.setVehicle(vehicle);
                    vehicle.getAvailabilities().add(newAvailability);
                }

                vehicle.getAvailabilities().remove(availability);
                vehicleRepository.save(vehicle);

                availabilityRepository.deleteById(availability.getId());

                return availabilityRepository.findByVehicleId(id);

            }
        }

        return null;
    }
}
