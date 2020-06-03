package com.programatori.locationservice.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
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
