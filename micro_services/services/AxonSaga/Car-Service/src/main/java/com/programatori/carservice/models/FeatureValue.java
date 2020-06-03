package com.programatori.carservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "feature_value_car_service")
public class FeatureValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FeatureType type;

    @ManyToMany(mappedBy = "features")
    private Set<Vehicle> vehicles;

    public FeatureValue() {
    }
}