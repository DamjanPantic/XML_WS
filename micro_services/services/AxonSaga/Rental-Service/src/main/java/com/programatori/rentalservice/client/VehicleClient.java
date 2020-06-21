package com.programatori.rentalservice.client;

import com.programatori.rentalservice.dto.VehicleBasicDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "vehicle")
public interface VehicleClient {
    @GetMapping(path = "/basic-info")
    public List<VehicleBasicDTO> getVehicles(@RequestHeader(name = "Authorization") String token);
}

