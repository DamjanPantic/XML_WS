package com.programatori.carservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vehicle_car_service")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Model model;

    @ManyToMany(fetch = FetchType.LAZY ,cascade = CascadeType.DETACH)
    @JoinTable(
            name = "vehicle_features_car_service",
            joinColumns = @JoinColumn(
                    name = "vehicle_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "feature_id", referencedColumnName = "id"))
    private Set<FeatureValue> features;

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

    private String carToken;

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", owner=" + owner +
                ", model=" + model +
                ", features=" + features +
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
