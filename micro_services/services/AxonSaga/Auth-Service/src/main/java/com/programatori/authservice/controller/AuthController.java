package com.programatori.authservice.controller;

import com.programatori.authservice.configuration.JwtTokenUtil;
import com.programatori.authservice.models.User;
import com.programatori.authservice.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class AuthController {

    @Autowired
    IUserService userService;

    @GetMapping("/hello")
    public ResponseEntity<?> get() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        return new ResponseEntity<>(String.format("Hello from Auth service with ip address %s!", ip), HttpStatus.OK);
    }

    @RequestMapping(consumes = "application/json",value="/signup",method = RequestMethod.POST)
    public ResponseEntity<User> signIn(@RequestBody User user){
        return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
    }


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

}
