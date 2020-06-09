package com.programatori.authservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programatori.authservice.repository.IUserRepository;
import com.programatori.authservice.service.UserDetailServiceImpl;
import org.springframework.security.core.userdetails.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;


    private UserDetailServiceImpl userDetailService;

    @Autowired
    IUserRepository userRepository;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserDetailServiceImpl userDetailService) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
    }



    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            com.programatori.authservice.models.User creds = new ObjectMapper()
                    .readValue(req.getInputStream(), com.programatori.authservice.models.User.class);
            System.out.println(creds.getUsername()+creds.getPassword());
            com.programatori.authservice.models.User user = userDetailService.findByUsername(creds.getUsername());
            System.out.println(user.getBlocked());
            UserDetails userDetails = userDetailService.loadUserByUsername(creds.getUsername());
            if(user.getBlocked() != null){
                if(user.getBlocked() == true)
                    throw new IOException();
            }
            Authentication authentication =  authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            (userDetails.getAuthorities()))
            );
            return authentication;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        System.out.println("generisanje tokena");
        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .sign(HMAC512(SecurityConstants.SECRET.getBytes()));
        System.out.println(token);
        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
        res.addHeader("moj heder","123");
        res.setHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
        System.out.println(res);
    }


}
