package com.programatori.searchservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "transmission_search_service")
public class Transmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "transmission", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();

    public Transmission() {
    }
}
