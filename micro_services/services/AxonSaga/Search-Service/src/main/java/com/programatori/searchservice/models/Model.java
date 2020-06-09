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
@Table(name = "model_search_service")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Manufacturer manufacturer;

    @JsonIgnore
    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();

    public Model() {
    }
}
