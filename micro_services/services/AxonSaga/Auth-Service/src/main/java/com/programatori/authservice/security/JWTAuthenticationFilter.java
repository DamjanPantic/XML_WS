package com.programatori.authservice.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programatori.authservice.service.UserDetailServiceImpl;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private static Logger log = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    private UserDetailServiceImpl userDetailService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserDetailServiceImpl userDetailService) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
    }



    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        com.programatori.authservice.models.User creds = null;
        try {
            creds = new ObjectMapper()
                    .readValue(req.getInputStream(), com.programatori.authservice.models.User.class);
            System.out.println(creds.getUsername()+creds.getPassword());
            com.programatori.authservice.models.User user = userDetailService.findByUsername(creds.getUsername());
            if(user == null){
                user = userDetailService.findByEmail(creds.getEmail());
            }
            UserDetails userDetails = userDetailService.loadUserByUsername(creds.getUsername());
            log.info(String.format("login attempt username: %s ", creds.getUsername()));
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
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
        com.programatori.authservice.models.User creds = null;
        try {
            creds = new ObjectMapper()
                    .readValue(request.getInputStream(), com.programatori.authservice.models.User.class);
        }catch (Exception e){}
        System.out.println("remote address " + request.getRemoteAddr());
        System.out.println("creds " + failed.getCause());
        log.warn(String.format("login attempt failed ip address: %s", request.getRemoteAddr()));
    }

    @Override
    protected AuthenticationFailureHandler getFailureHandler() {
        System.out.println("failed autgentication");
        return super.getFailureHandler();
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        UserDetails userDetails = userDetailService.loadUserByUsername(((User) auth.getPrincipal()).getUsername());
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) userDetails.getAuthorities();
        String authorityClaims = "";
        Iterator<GrantedAuthority> authorityIterator = authorities.iterator();
        while(authorityIterator.hasNext()){
            authorityClaims+=authorityIterator.next().getAuthority();
            if(authorityIterator.hasNext())
                authorityClaims+="/";
        }

        com.programatori.authservice.models.User user =
                userDetailService.findByEmail(((User) auth.getPrincipal()).getUsername());
        System.out.println(authorityClaims);
        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withClaim("roles",authorityClaims)
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .sign(HMAC512(SecurityConstants.SECRET.getBytes()));
        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
        res.setHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
    }


}
