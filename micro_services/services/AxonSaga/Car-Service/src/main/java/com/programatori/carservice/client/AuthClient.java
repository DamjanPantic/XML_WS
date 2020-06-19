package com.programatori.carservice.client;

import com.programatori.carservice.models.Availability;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth")
public interface AuthClient {
    @GetMapping(path = "/users/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email);
}
