package com.programatori.carservice.client;

import com.programatori.carservice.models.Availability;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "rental")
public interface RentalClient {

    @DeleteMapping(path = "/{vehicleId}")
    public ResponseEntity<?> checkValidationOfRenatalRequests(@PathVariable Long vehicleId, @RequestBody Availability availability);
}
