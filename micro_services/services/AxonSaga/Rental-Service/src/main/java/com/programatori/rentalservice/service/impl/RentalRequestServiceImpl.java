package com.programatori.rentalservice.service.impl;

import com.programatori.rentalservice.dto.RentalRequestDTO;
import com.programatori.rentalservice.models.RentalRequest;
import com.programatori.rentalservice.models.RentalRequestStatus;
import com.programatori.rentalservice.models.Vehicle;
import com.programatori.rentalservice.repository.RentalRequestRepository;
import com.programatori.rentalservice.repository.VehicleRepository;
import com.programatori.rentalservice.service.RentalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RentalRequestServiceImpl implements RentalRequestService {

    @Autowired
    RentalRequestRepository rentalRequestRepository;

    @Autowired
    VehicleRepository vehicleRepository;


    @Override
    public ResponseEntity<?> addRentalRequest(List<RentalRequestDTO> rentalRequestDTOS) throws ParseException {
        Map<Long,List<RentalRequestDTO>> requestToOwner = new HashMap<>();
        for(RentalRequestDTO rentalRequestDTO : rentalRequestDTOS) {
            Vehicle vehicle = vehicleRepository.findByVehicleId(rentalRequestDTO.getVehicleId());
            if (vehicle == null) {
                Vehicle v = new Vehicle();
                v.setVehicleId(rentalRequestDTO.getVehicleId());
                vehicleRepository.save(v);
            }
            if(requestToOwner.containsKey(rentalRequestDTO.getOwnerId())){
                requestToOwner.get(rentalRequestDTO.getOwnerId()).add(rentalRequestDTO);
            }else {
                List<RentalRequestDTO> values = new ArrayList<>();
                values.add(rentalRequestDTO);
                requestToOwner.put(rentalRequestDTO.getOwnerId(),values);
            }
        }
        for(List<RentalRequestDTO> requests : requestToOwner.values()){
            boolean bundle=false;
            List<Vehicle> vehicles = new ArrayList<>();
            for(RentalRequestDTO requestDTO : requests){
                if(requestDTO.getBundle()){
                    vehicles.add(vehicleRepository.findByVehicleId(requestDTO.getVehicleId()));
                    bundle = true;
                }else{
                    RentalRequest rentalRequest = new RentalRequest();
                    rentalRequest.setCustomerId(requestDTO.getCustomerId());
                    rentalRequest.setStatus(RentalRequestStatus.PENDING);
                    rentalRequest.setOwnerId(requestDTO.getOwnerId());
                    rentalRequest.setFromDate(new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(requestDTO.getFromDate()));
                    rentalRequest.setToDate(new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(requestDTO.getToDate()));
                    List<Vehicle> vehicles1 = new ArrayList<>();
                    vehicles1.add(vehicleRepository.findByVehicleId(requestDTO.getVehicleId()));
                    rentalRequest.setVehicleIds(vehicles1);
                    rentalRequestRepository.save(rentalRequest);
                }
            }
            if(bundle){
                RentalRequest rentalRequest = new RentalRequest();
                rentalRequest.setCustomerId(requests.get(0).getCustomerId());
                rentalRequest.setStatus(RentalRequestStatus.PENDING);
                rentalRequest.setOwnerId(requests.get(0).getOwnerId());
                rentalRequest.setFromDate(new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(requests.get(0).getFromDate()));
                rentalRequest.setToDate(new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(requests.get(0).getToDate()));
                rentalRequest.setVehicleIds(vehicles);
                rentalRequestRepository.save(rentalRequest);
            }

        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
