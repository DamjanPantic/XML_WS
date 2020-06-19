package com.programatori.rentalservice.controller;

import com.programatori.rentalservice.dto.ApproveDenyRequestDTO;
import com.programatori.rentalservice.dto.AvailabilityDTO;
import com.programatori.rentalservice.dto.RentalRequestDTO;
import com.programatori.rentalservice.service.RentalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.List;

@RestController
public class RentalController {

    @Autowired
    RentalRequestService rentalRequestService;

    @GetMapping("/hello")
    public ResponseEntity<?> get() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        return new ResponseEntity<>(String.format("Hello from Rental service with ip address %s!", ip), HttpStatus.OK);
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addRenatalRequests(@RequestBody List<RentalRequestDTO> rentalRequestDTOS) throws  ParseException {
        Object pricnicpal  = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println((String) pricnicpal);
        return rentalRequestService.addRentalRequest(rentalRequestDTOS);
    }

    @DeleteMapping(path = "/{vehicleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkValidationOfRenatalRequests(@PathVariable Long vehicleId, @RequestBody AvailabilityDTO availabilityDTO) {

        return rentalRequestService.deleteInvalidRentals(vehicleId, availabilityDTO);
    }

    @GetMapping("/pending/{owner}")
    public ResponseEntity<?> getPendingRequestsByOwner(@PathVariable Long owner){
        return rentalRequestService.listPendingRequests(owner);
    }

    @PutMapping(path = "/approval", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> approveDenyRentalRequest(@RequestBody ApproveDenyRequestDTO approveDenyRequestDTO){
        return rentalRequestService.approveDenyRequest(approveDenyRequestDTO);
    }

    @Scheduled(fixedRate=10000)
    public void clearRequests() {
        rentalRequestService.clearRequests();
    }

    @PostMapping(path="/{id}/pay")
    public ResponseEntity<?> payRental(@PathVariable Long id){
        return rentalRequestService.pay(id);
    }

}
