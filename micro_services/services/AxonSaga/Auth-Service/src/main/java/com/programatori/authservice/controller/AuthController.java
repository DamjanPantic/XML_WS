package com.programatori.authservice.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.programatori.authservice.models.User;
import com.programatori.authservice.repository.IUserRepository;
import com.programatori.authservice.security.SecurityConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class AuthController {

    @Autowired
    private IUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthController(){
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }


    @GetMapping("/hello")
    public ResponseEntity<?> get() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        return new ResponseEntity<>(String.format("Hello from Auth service with ip address %s!", ip), HttpStatus.OK);
    }

    @RequestMapping(consumes = "application/json",value="/sign-up",method = RequestMethod.POST)
    public ResponseEntity<User> signIn(@Valid @RequestBody User user){
        String pass = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        applicationUserRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public User me(HttpServletRequest request){
        String token = request.getHeader(SecurityConstants.HEADER_STRING).replace(SecurityConstants.TOKEN_PREFIX,"");
        DecodedJWT jwt = JWT.decode(token);
        System.out.println(jwt.getSubject());

        return applicationUserRepository.findByUsername(jwt.getSubject());
    }



}
