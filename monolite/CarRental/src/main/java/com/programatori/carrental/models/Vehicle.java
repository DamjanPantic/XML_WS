package com.programatori.carrental.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Transmission transmission;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private FuelType fuelType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private VehicleType vehicleType;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<Price> prices = new HashSet<Price>();

    private Double traveledKm;

    private String limitKm;

    private Integer kidsSeatsNo;

    private Boolean cdw;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Availability> availabilities = new HashSet<Availability>();

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Image> images = new HashSet<Image>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.DETACH, mappedBy = "vehicles")
    private List<RentalRequest> rentalRequests;

    private String carToken;

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", owner=" + owner +
                ", model=" + model +
                ", prices=" + prices +
                ", traveledKm=" + traveledKm +
                ", limitKm='" + limitKm + '\'' +
                ", kidsSeatsNo=" + kidsSeatsNo +
                ", cdw=" + cdw +
                ", availabilities=" + availabilities +
                ", images=" + images +
                ", carToken='" + carToken + '\'' +
                '}';
    }
}
