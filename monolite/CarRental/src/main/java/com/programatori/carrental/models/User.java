package com.programatori.carrental.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();

    @JsonIgnore
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<RentalRequest> rentalRequestsOwners = new HashSet<RentalRequest>();

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<RentalRequest> rentalRequestsCustomers = new HashSet<RentalRequest>();

    @JsonIgnore
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<Message> messagesSender;

    @JsonIgnore
    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<Message> messagesReceiver;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<Grade> grades;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<Comment> comments;


    public User() {
    }
}
