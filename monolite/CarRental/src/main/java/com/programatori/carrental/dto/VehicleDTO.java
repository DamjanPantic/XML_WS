package com.programatori.carrental.dto;

import com.programatori.carrental.models.Image;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class VehicleDTO {

    private Long id;
    private UserDTO owner;
    private ModelDTO model;
    private Set<PriceDTO> prices;
    private TransmissionDTO transmission;
    private FuelTypeDTO fuelType;
    private VehicleTypeDTO vehicleType;
    private Double traveledKm;
    private String limitKm;
    private Integer kidsSeatsNo;
    private Boolean cdw;
    private Set<AvailabilityDTO> availabilities;
    private Set<Image> images;
    private String carToken;
}
