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

    private String place;

    private Date fromDate;

    private Date toDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Vehicle vehicle;

    public Availability() {
    }
}
