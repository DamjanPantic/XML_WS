package com.programatori.recensionservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "rental")
public interface RentalClient {

    @GetMapping(path = "/{customerId}/{vehicleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean getRentalRequestByParams(@PathVariable Long customerId,@PathVariable Long vehicleId);
}
