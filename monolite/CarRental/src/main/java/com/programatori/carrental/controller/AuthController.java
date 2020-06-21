package com.programatori.carrental.controller;

import com.programatori.carrental.models.User;
import com.programatori.carrental.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping(consumes = "application/json",value="/register",method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody User user){

        return authService.registerUser(user);
    }

    @RequestMapping(consumes = "application/json",value="/login",method = RequestMethod.POST)
    public ResponseEntity<?> signIn(@RequestBody User user){

        return authService.loginUser(user);
    }
}
