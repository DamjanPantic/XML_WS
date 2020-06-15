package com.programatori.rentalservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "rental_request_rental_service")
public class RentalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private Date fromDate;

    @Column(nullable = false)
    private Date toDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RentalRequestStatus status;

    @ManyToMany(fetch = FetchType.LAZY ,cascade = CascadeType.DETACH)
    @JoinTable(
            name = "rental_request_vehicles_rental_service",
            joinColumns = @JoinColumn(
                    name = "rental_request_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "vehicle_id", referencedColumnName = "id"))
    private List<Vehicle> vehicleIds;

    @Column(nullable = true)
    private Boolean approved;

    private Long creationTime;

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
