package com.programatori.authservice.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.programatori.authservice.models.Individual;
import com.programatori.authservice.models.Role;
import com.programatori.authservice.models.User;
import com.programatori.authservice.repository.IUserRepository;
import com.programatori.authservice.repository.RoleRepository;
import com.programatori.authservice.security.SecurityConstants;
import com.programatori.authservice.service.IUserDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    private IUserRepository applicationUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private IUserDetailService userDetailService;

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
    public ResponseEntity<User> signUp(@Valid @RequestBody User user){
        String pass = bCryptPasswordEncoder.encode(user.getPassword());
        Individual individual = new Individual();
        individual.setPassword(pass);
        individual.setEmail(user.getEmail());
        individual.setUsername(user.getUsername());
        Role role = roleRepository.findByName("ROLE_PUBLISHER");
        individual.setRoles(Arrays.asList(role));
        applicationUserRepository.save(individual);
        return new ResponseEntity<User>(individual, HttpStatus.CREATED);
    }



    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public User me(HttpServletRequest request){
        String token = request.getHeader(SecurityConstants.HEADER_STRING).replace(SecurityConstants.TOKEN_PREFIX,"");
        DecodedJWT jwt = JWT.decode(token);
        System.out.println(jwt.getSubject());

        return applicationUserRepository.findByUsername(jwt.getSubject());
    }

    @PreAuthorize("hasAuthority('USER_MANIPULATION_PRIVILEGE')")
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        Boolean user = userDetailService.deleteById(id);
        return new ResponseEntity<Boolean>(user,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER_MANIPULATION_PRIVILEGE')")
    @RequestMapping(value = "/users/block/{id}",method = RequestMethod.PUT)
    public ResponseEntity<User> block(@PathVariable Long id){
        User user = userDetailService.blockUserById(id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }








}
