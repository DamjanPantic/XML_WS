package com.programatori.authservice.components;

import com.programatori.authservice.models.*;
import com.programatori.authservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent>{

    //ovo menjas na true kada pokrenes jednom
    //prvi put na false
    boolean alreadySetup = false;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IAdminRepository adminRepository;

    @Autowired
    private IIndividualRepository individualRepository;

    @Autowired
    private  IComanyRepository comanyRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("PUBLISH_PRIVILEGE");
        Privilege orderPrivilege
                = createPrivilegeIfNotFound("ORDER_PRIVILEGE");
        Privilege userManipulationPrivilege
                = createPrivilegeIfNotFound("USER_MANIPULATION_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege, userManipulationPrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_PUBLISHER", Arrays.asList(readPrivilege, writePrivilege));
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege,orderPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        Admin user = new Admin();
        user.setUsername("Test");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.com");
        user.setRoles(new HashSet<Role>(Arrays.asList(adminRole)));
        userRepository.save(user);

        Role publisherRole = roleRepository.findByName("ROLE_PUBLISHER");
        Company user2 = new Company();
        user2.setUsername("Company1");
        user2.setPassword(passwordEncoder.encode("test"));
        user2.setEmail("company@company.com");
        user2.setRoles(new HashSet<Role>(Arrays.asList(publisherRole)));
        userRepository.save(user2);

        Individual user3 = new Individual();
        user3.setUsername("Individual1");
        user3.setPassword(passwordEncoder.encode("test"));
        user3.setEmail("individual@individual.com");
        user3.setRoles(new HashSet<Role>(Arrays.asList(publisherRole)));
        userRepository.save(user3);



        alreadySetup = true;
    }

    @Transactional
    private Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}