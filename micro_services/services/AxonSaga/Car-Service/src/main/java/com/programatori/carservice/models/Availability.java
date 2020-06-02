package com.programatori.carservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "availability_car_service")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String place;

    @Column(unique = true,nullable = false)
    private Date from;

    @Column(unique = true,nullable = false)
    private Date to;

    public Availability() {
    }
}
