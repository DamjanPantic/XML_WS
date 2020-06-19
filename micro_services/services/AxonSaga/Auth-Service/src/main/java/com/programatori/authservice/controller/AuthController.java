package com.programatori.authservice.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.programatori.authservice.models.Individual;
import com.programatori.authservice.models.Role;
import com.programatori.authservice.models.User;
import com.programatori.authservice.repository.IUserRepository;
import com.programatori.authservice.repository.RoleRepository;
import com.programatori.authservice.security.SecurityConstants;
import com.programatori.authservice.service.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

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

    @RequestMapping(consumes = "application/json",value="/sign-up",method = RequestMethod.POST)
    public ResponseEntity<User> signUp(@Valid @RequestBody User user){
        String pass = bCryptPasswordEncoder.encode(user.getPassword());
        Individual individual = new Individual();
        individual.setPassword(pass);
        individual.setEmail(user.getEmail());
        individual.setUsername(user.getUsername());
        Role role = roleRepository.findByName("ROLE_PUBLISHER");
        individual.setRoles(new HashSet<>(Arrays.asList(role)));
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

    @PreAuthorize("hasAuthority('USER_MANIPULATION_PRIVILEGE')")
    @RequestMapping(value = "/users/un-block/{id}",method = RequestMethod.PUT)
    public ResponseEntity<User> unBlock(@PathVariable Long id){
        User user = userDetailService.unBlockUserById(id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER_MANIPULATION_PRIVILEGE')")
    @RequestMapping(value = "/users/{id}/roles/{role}",method = RequestMethod.PUT)
    public ResponseEntity<User> changeRole(@PathVariable Long id,@PathVariable String role){
        User user = userDetailService.updateRole(role,id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    public ResponseEntity<?> verifyToken(HttpServletRequest request){

        String token = null;
        try {
            token = request.getHeader(SecurityConstants.HEADER_STRING).replace(SecurityConstants.TOKEN_PREFIX,"");
        }catch (Exception e){}

        String user;
        HttpHeaders responseHeaders = null;
        try {
            DecodedJWT jwt = JWT.decode(token);
            user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                    .getSubject();

            Map<String, Claim> claims = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                    .getClaims();

            String authorityClaims = claims.get("roles").asString();
            responseHeaders = new HttpHeaders();
            responseHeaders.set("roles",authorityClaims);


        }catch (Exception e){
            user = null;
        }
        if (user != null) {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(true);
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER_MANIPULATION_PRIVILEGE')")
    @RequestMapping(value = "/users/{email}",method = RequestMethod.PUT)
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        User user = userDetailService.findByEmail(email);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }













}
