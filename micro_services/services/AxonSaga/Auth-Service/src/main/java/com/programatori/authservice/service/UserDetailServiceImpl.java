package com.programatori.authservice.service;

import com.programatori.authservice.models.Individual;
import com.programatori.authservice.models.Privilege;
import com.programatori.authservice.models.Role;
import com.programatori.authservice.repository.IUserRepository;
import com.programatori.authservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.*;


@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService, IUserDetailService{

    @Autowired
    IUserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailServiceImpl(){
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }


    public com.programatori.authservice.models.User save(com.programatori.authservice.models.User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        com.programatori.authservice.models.User u = new com.programatori.authservice.models.User();
        u.setEmail(user.getEmail());
        u.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        u.setUsername(user.getUsername());
        u.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("ROLE_USER"))));

        return userRepository.save(u);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.programatori.authservice.models.User applicationUser = userRepository.findByUsername(s);

        if (applicationUser == null) {
            applicationUser = userRepository.findByEmail(s);
            if(applicationUser != null){
                UserDetails details = new org.springframework.security.core.userdetails.User(
                        applicationUser.getEmail(), applicationUser.getPassword(), true, true, true,
                        true, getAuthorities(applicationUser.getRoles()));
                System.out.println(details.getAuthorities());
                return details;
            }
            return new org.springframework.security.core.userdetails.User(
                    " ", " ", true, true, true, true,
                    getAuthorities(Arrays.asList(
                            roleRepository.findByName("ROLE_USER"))));
        }

        UserDetails details = new org.springframework.security.core.userdetails.User(
                applicationUser.getEmail(), applicationUser.getPassword(), true, true, true,
                true, getAuthorities(applicationUser.getRoles()));
        System.out.println(details.getAuthorities());
        return details;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        return getGrantedAuthorities(getPrivileges(roles));
    }
    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    public Boolean deleteById(Long id){
        com.programatori.authservice.models.User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public Individual saveIndividual(com.programatori.authservice.models.User user) {
        Individual individual = new Individual();
        individual.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        individual.setUsername(user.getUsername());
        individual.setEmail(user.getEmail());
        Role individualRole = roleRepository.findByName("ROLE_PUBLISHER");
        individual.setRoles(new HashSet<>(Arrays.asList(individualRole)));
        return null;
    }

    @Override
    public com.programatori.authservice.models.User blockUserById(Long id) {
        com.programatori.authservice.models.User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return null;
        }
        user.setBlocked(true);
        userRepository.save(user);
        return user;
    }

    @Override
    public com.programatori.authservice.models.User unBlockUserById(Long id) {
        com.programatori.authservice.models.User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return null;
        }
        user.setBlocked(false);
        userRepository.save(user);
        return user;
    }

    @Override
    public com.programatori.authservice.models.User findByUsername(String username) {
        com.programatori.authservice.models.User user = userRepository.findByUsername(username);
        return user;
    }


}
