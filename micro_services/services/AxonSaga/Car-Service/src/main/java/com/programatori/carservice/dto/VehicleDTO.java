package com.programatori.carservice.dto;

import com.programatori.carservice.models.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class VehicleDTO {

    private ModelDTO model;
    private Set<FeatureValueDTO> features;
    private Set<PriceDTO> prices;
    private Double traveledKm;
    private String limitKm;
    private Integer kidsSeatsNo;
    private Boolean cdw;
    private Set<LikeDislikeDTO> likes;
    private Set<CommentDTO> comments;
    private Set<AvailabilityDTO> availabilities;
    private Set<LocationEntryDTO> locationEntries;
    private String carToken;

    public VehicleDTO(Vehicle vehicle) {
        this.model = new ModelDTO(vehicle.getModel());

        Set<FeatureValueDTO> featuresDTO = new HashSet<>();
        for (FeatureValue feature: vehicle.getFeatures()) {
            featuresDTO.add(new FeatureValueDTO(feature));
        }
        this.features = featuresDTO;

        this.traveledKm = vehicle.getTraveledKm();
        this.limitKm = vehicle.getLimitKm();
        this.kidsSeatsNo = vehicle.getKidsSeatsNo();
        this.cdw = vehicle.getCdw();

        Set<LikeDislikeDTO> likesDTO = new HashSet<>();
        for (LikeDislike like: vehicle.getLikes()) {
            likesDTO.add(new LikeDislikeDTO(like));
        }
        this.likes = likesDTO;

        Set<CommentDTO> comentsDTO = new HashSet<>();
        for (Comment comment: vehicle.getComments()) {
            comentsDTO.add(new CommentDTO(comment));
        }
        this.comments = comentsDTO;

        Set<AvailabilityDTO> availabilityDTO = new HashSet<>();
        for (Availability availability: vehicle.getAvailabilities()) {
            availabilityDTO.add(new AvailabilityDTO(availability));
        }
        this.availabilities = availabilityDTO;

        Set<LocationEntryDTO> locationEntryDTO = new HashSet<>();
        for (LocationEntry locationEntry: vehicle.getLocationEntries()) {
            locationEntryDTO.add(new LocationEntryDTO(locationEntry));
        }
        this.locationEntries = locationEntryDTO;

        this.carToken = vehicle.getCarToken();

    }
}
