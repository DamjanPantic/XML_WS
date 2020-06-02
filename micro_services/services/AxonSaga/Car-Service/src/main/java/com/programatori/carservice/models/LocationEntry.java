package com.programatori.carservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "availability_car_service")
public class LocationEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private Double lat;

    @Column(unique = true,nullable = false)
    private Double lng;

    public LocationEntry() {
    }
}
