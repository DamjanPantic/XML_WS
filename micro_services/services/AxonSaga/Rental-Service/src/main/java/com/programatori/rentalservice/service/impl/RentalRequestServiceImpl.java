package com.programatori.rentalservice.service.impl;

import com.programatori.rentalservice.configuration.SpringConfig;
import com.programatori.rentalservice.dto.ApproveDenyRequestDTO;
import com.programatori.rentalservice.dto.AvailabilityDTO;
import com.programatori.rentalservice.dto.RentalRequestDTO;
import com.programatori.rentalservice.models.RentalRequest;
import com.programatori.rentalservice.models.RentalRequestStatus;
import com.programatori.rentalservice.models.Vehicle;
import com.programatori.rentalservice.repository.RentalRequestRepository;
import com.programatori.rentalservice.repository.VehicleRepository;
import com.programatori.rentalservice.service.RentalRequestService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RentalRequestServiceImpl implements RentalRequestService {

    @Autowired
    RentalRequestRepository rentalRequestRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    DozerBeanMapper mapper = new DozerBeanMapper();


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

    @Override
    public ResponseEntity<?> deleteInvalidRentals(Long vehicleId, AvailabilityDTO availabilityDTO) {

        List<RentalRequest> rentalRequests = rentalRequestRepository.findInvalidRentals(vehicleId,
                availabilityDTO.getFromDate(), availabilityDTO.getToDate());

        if (rentalRequests != null){
            for(RentalRequest rentalRequest: rentalRequests){
                rentalRequestRepository.delete(rentalRequest);
            }
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> approveDenyRequest(ApproveDenyRequestDTO approveDenyRequestDTO) {
        System.out.println(approveDenyRequestDTO.getVehicleId());
        Vehicle vehicle = vehicleRepository.findByVehicleId(approveDenyRequestDTO.getVehicleId());
        if(vehicle == null){
            System.out.println("vehicle null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        RentalRequest rentalRequest = rentalRequestRepository.getOne(approveDenyRequestDTO.getRequestId());
        if(rentalRequest == null ){
            System.out.println("request null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(rentalRequest.getStatus() == RentalRequestStatus.PAID || rentalRequest.getStatus() == RentalRequestStatus.CANCELED){
            System.out.println("cancelled");

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(approveDenyRequestDTO.isApprove()){
            rentalRequest.setRequestStatus(RentalRequestStatus.RESERVED);
        }else{
            rentalRequest.setRequestStatus(RentalRequestStatus.DENIED);
        }
        rentalRequestRepository.save(rentalRequest);

        return new ResponseEntity<RentalRequestServiceImpl>(HttpStatus.OK);
    }

    @Override
    public List<?> listPendingRequests(Long ownerId) {
        return rentalRequestRepository.findRentalRequestByOwnerIdAndStatus(ownerId, RentalRequestStatus.PENDING);
    }

    @Override
    public void clearRequests() {
        System.out.println("clearing");
        List<RentalRequest> requests = rentalRequestRepository.findAll();
        System.out.println(requests);
        List<RentalRequest> pendingRequests = rentalRequestRepository.findRentalRequestByStatus(RentalRequestStatus.PENDING);
        List<RentalRequest> reserved = rentalRequestRepository.findRentalRequestByStatus(RentalRequestStatus.RESERVED);
        System.out.println(pendingRequests);
        for (RentalRequest r : pendingRequests) {
            if (System.currentTimeMillis() - r.getCreationTime() >= SpringConfig.PENDING_REQUEST_CLEARING) {
                r.setStatus(RentalRequestStatus.CANCELED);
                rentalRequestRepository.save(r);
            }
        }

        for (RentalRequest r : reserved) {
            try {
                if (System.currentTimeMillis() - r.getApprovalTime() >= SpringConfig.RESERVED_REQUEST_CLEARING) {
                    r.setStatus(RentalRequestStatus.CANCELED);
                    rentalRequestRepository.save(r);
                }
            }catch (Exception e){}
        }

    }

    @Override
    public ResponseEntity<?> pay(Long requestId) {
        RentalRequest rentalRequest = rentalRequestRepository.getOne(requestId);
        if(rentalRequest == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        rentalRequest.setStatus(RentalRequestStatus.PAID);
        rentalRequestRepository.save(rentalRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Long rentalId) {
        RentalRequest rentalRequest = rentalRequestRepository.findOneById(rentalId);
        if(rentalRequest == null){
            return new ResponseEntity<>("Rental request with that ID dont exist",HttpStatus.BAD_REQUEST);
        }
        RentalRequestDTO rentalRequestDTO = mapper.map(rentalRequest, RentalRequestDTO.class);

        return new ResponseEntity<>(rentalRequestDTO,HttpStatus.OK);
    }

    @Override
    public Boolean getRentalRequestByParams(Long customerId, Long vehicleId) {

        return rentalRequestRepository.findRentalRequestByStatusAndDate(new Date(),customerId,vehicleId);

    }




}
