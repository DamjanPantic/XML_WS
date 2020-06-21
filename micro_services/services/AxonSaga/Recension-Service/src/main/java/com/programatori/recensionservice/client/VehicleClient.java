package com.programatori.recensionservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vehicle")
public interface VehicleClient {
    @GetMapping(value = "/model/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getVehicleModelById(@PathVariable Long id);
}

