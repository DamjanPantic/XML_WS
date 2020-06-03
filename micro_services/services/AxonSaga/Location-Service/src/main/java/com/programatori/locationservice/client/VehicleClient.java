package com.programatori.locationservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "vehicle")
public interface VehicleClient {
    @GetMapping("/token/{token}")
    Long getVehicleIdByToken(@PathVariable("token") String token);
}
