package com.programatori.carrental.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "rental_request")
public class RentalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private User customer;

    @Column(nullable = false)
    private Date fromDate;

    @Column(nullable = false)
    private Date toDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RentalRequestStatus status;

    @ManyToMany(fetch = FetchType.LAZY ,cascade = CascadeType.DETACH)
    @JoinTable(
            name = "rental_request_vehicles",
            joinColumns = @JoinColumn(
                    name = "rental_request_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "vehicle_id", referencedColumnName = "id"))
    private List<Vehicle> vehicles;

    private Long creationTime;

    @JsonIgnore
    @OneToMany(mappedBy = "rentalRequest", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<Message> messages;

    @JsonIgnore
    @OneToMany(mappedBy = "request", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Set<RentalReport> reports = new HashSet<RentalReport>();

    @PrePersist
    protected void onCreate() {
        creationTime = System.currentTimeMillis();
    }

    private Long approvalTime;

    public void setRequestStatus(RentalRequestStatus status){
        if(status == RentalRequestStatus.RESERVED){
            approvalTime = System.currentTimeMillis();
        }
        this.status = status;
    }


}
