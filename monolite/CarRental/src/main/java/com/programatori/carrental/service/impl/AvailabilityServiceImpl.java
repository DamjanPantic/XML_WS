package com.programatori.carrental.service.impl;

import com.programatori.carrental.dto.AvailabilityDTO;
import com.programatori.carrental.models.Availability;
import com.programatori.carrental.models.RentalRequest;
import com.programatori.carrental.models.Vehicle;
import com.programatori.carrental.repository.AvailabilityRepository;
import com.programatori.carrental.repository.RentalRequestRepository;
import com.programatori.carrental.repository.VehicleRepository;
import com.programatori.carrental.service.AvailabilityService;
import org.apache.commons.lang3.time.DateUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    AvailabilityRepository availabilityRepository;

    @Autowired
    RentalRequestRepository rentalRequestRepository;

    DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public ResponseEntity<?> addReservation(Long id, AvailabilityDTO availabilityDTO) throws ParseException {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        if (vehicle == null) {
            return new ResponseEntity<>("Vehicle dont exist",HttpStatus.BAD_REQUEST);
        }

        if (vehicle.getAvailabilities() == null) {
            return new ResponseEntity<>("Vehicle isnt available", HttpStatus.BAD_REQUEST);
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

                List<RentalRequest> rentalRequests = rentalRequestRepository.findInvalidRentals(id, fromDate, toDate);
                System.out.println(rentalRequests.toString());
                if (rentalRequests != null){
                    for(RentalRequest rentalRequest: rentalRequests){
                        rentalRequestRepository.delete(rentalRequest);
                    }
                }


                return new ResponseEntity<>( availabilityRepository.findAll(), HttpStatus.OK);

            }
        }


        return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
    }
}
