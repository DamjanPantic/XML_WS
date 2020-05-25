package com.programatori.authservice.service;

import com.programatori.authservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    IUserRepository userRepository;

    public UserDetailServiceImpl(IUserRepository userRepository){
        this.userRepository = userRepository;
    }


    public com.programatori.authservice.models.User save(com.programatori.authservice.models.User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        com.programatori.authservice.models.User u = new com.programatori.authservice.models.User();
        u.setEmail(user.getEmail());
        u.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        u.setUsername(user.getUsername());
        return userRepository.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.programatori.authservice.models.User applicationUser = userRepository.findByUsername(s);
        System.out.println(applicationUser);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(s);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}
