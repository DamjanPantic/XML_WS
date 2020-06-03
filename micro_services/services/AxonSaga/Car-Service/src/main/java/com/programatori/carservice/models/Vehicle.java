package com.programatori.carservice.models;

import com.programatori.carservice.dto.VehicleDTO;
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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private User owner;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Model model;

    @ManyToMany
    @JoinTable(
            name = "vehicle_features_car_service",
            joinColumns = @JoinColumn(
                    name = "vehicle_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "feature_id", referencedColumnName = "id"))
    private Set<FeatureValue> features;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Price> prices = new HashSet<Price>();

    private Double traveledKm;

    private String limitKm;

    private Integer kidsSeatsNo;

    private Boolean cdw;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LikeDislike> likes = new HashSet<LikeDislike>();

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<Comment>();

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Availability> availabilities = new HashSet<Availability>();

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LocationEntry> locationEntries = new HashSet<LocationEntry>();

    private String carToken;

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", owners=" + owner +
                ", model=" + model +
                ", features=" + features +
                ", prices=" + prices +
                ", traveledKm=" + traveledKm +
                ", limitKm='" + limitKm + '\'' +
                ", kidsSeatsNo=" + kidsSeatsNo +
                ", cdw=" + cdw +
                ", likes=" + likes +
                ", comments=" + comments +
                ", availabilities=" + availabilities +
                ", locationEntries=" + locationEntries +
                ", carToken='" + carToken + '\'' +
                '}';
    }
}
