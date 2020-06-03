package com.programatori.locationservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "location_location_service")
public class LocationEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false,nullable = false)
    private String lat;

    @Column(unique = false,nullable = false)
    private String lng;

    @PrePersist
    protected void onCreate() {
        entryTime = System.currentTimeMillis();
    }

    private Long entryTime;

    @Column(unique = false, nullable = false)
    private Long carId;

}
