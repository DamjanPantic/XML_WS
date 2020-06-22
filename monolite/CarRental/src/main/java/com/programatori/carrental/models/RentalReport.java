package com.programatori.carrental.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class RentalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private RentalRequest request;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Vehicle vehicle;

    @Column(nullable = true)
    private String info;

    @Column(nullable = false)
    private Double distance;


}
