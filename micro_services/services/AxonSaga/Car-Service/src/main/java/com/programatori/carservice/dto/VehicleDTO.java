package com.programatori.carservice.dto;

import com.programatori.carservice.models.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class VehicleDTO {

    private Long id;
    private UserDTO owner;
    private ModelDTO model;
    private Set<FeatureValueDTO> features;
    private Set<PriceDTO> prices;
    private Double traveledKm;
    private String limitKm;
    private Integer kidsSeatsNo;
    private Boolean cdw;
    private Set<AvailabilityDTO> availabilities;
    private Set<Image> images;
    private String carToken;

    public VehicleDTO(){

    }


    public VehicleDTO(Vehicle vehicle) {
        this.owner = new UserDTO(vehicle.getOwner());
        this.model = new ModelDTO(vehicle.getModel());
        this.id = vehicle.getId();

        if (vehicle.getFeatures() != null){
            Set<FeatureValueDTO> featuresDTO = new HashSet<>();
            for (FeatureValue feature: vehicle.getFeatures()) {
                featuresDTO.add(new FeatureValueDTO(feature));
            }
            this.features = featuresDTO;
        }

        this.id=vehicle.getId();
        this.traveledKm = vehicle.getTraveledKm();
        this.limitKm = vehicle.getLimitKm();
        this.kidsSeatsNo = vehicle.getKidsSeatsNo();
        this.cdw = vehicle.getCdw();

        if (vehicle.getAvailabilities() != null){
            Set<AvailabilityDTO> availabilityDTO = new HashSet<>();
            for (Availability availability: vehicle.getAvailabilities()) {
                availabilityDTO.add(new AvailabilityDTO(availability));
            }
            this.availabilities = availabilityDTO;
        }

        this.images=vehicle.getImages();
        this.carToken = vehicle.getCarToken();

    }
}
