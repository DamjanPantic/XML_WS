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
    private Set<LikeDislikeDTO> likes;
    private Set<CommentDTO> comments;
    private Set<AvailabilityDTO> availabilities;
    private Set<LocationEntryDTO> locationEntries;
    private String carToken;

    public VehicleDTO(){

    }


    public VehicleDTO(Vehicle vehicle) {
        this.owner = new UserDTO(vehicle.getOwner());
        this.model = new ModelDTO(vehicle.getModel());

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

        if (vehicle.getLikes() != null){
            Set<LikeDislikeDTO> likesDTO = new HashSet<>();
            for (LikeDislike like: vehicle.getLikes()) {
                likesDTO.add(new LikeDislikeDTO(like));
            }
            this.likes = likesDTO;
        }

        if (vehicle.getComments() != null){
            Set<CommentDTO> comentsDTO = new HashSet<>();
            for (Comment comment: vehicle.getComments()) {
                comentsDTO.add(new CommentDTO(comment));
            }
            this.comments = comentsDTO;
        }

        if (vehicle.getAvailabilities() != null){
            Set<AvailabilityDTO> availabilityDTO = new HashSet<>();
            for (Availability availability: vehicle.getAvailabilities()) {
                availabilityDTO.add(new AvailabilityDTO(availability));
            }
            this.availabilities = availabilityDTO;
        }

        if (vehicle.getLocationEntries() != null){
            Set<LocationEntryDTO> locationEntryDTO = new HashSet<>();
            for (LocationEntry locationEntry: vehicle.getLocationEntries()) {
                locationEntryDTO.add(new LocationEntryDTO(locationEntry));
            }
            this.locationEntries = locationEntryDTO;
        }

        this.carToken = vehicle.getCarToken();

    }
}
