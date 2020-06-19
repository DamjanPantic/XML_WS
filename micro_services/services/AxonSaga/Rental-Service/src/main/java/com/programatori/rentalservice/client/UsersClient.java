package com.programatori.rentalservice.client;

import com.programatori.rentalservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "auth")
public interface UsersClient {
    @GetMapping(path = "/users/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email);

    @GetMapping(path = "/users")
    public List<UserDTO> getUsers();
}