package com.programatori.recensionservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "auth")
public interface UsersClient {
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable Long id);


}