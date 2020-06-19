package com.programatori.rentalservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeatureValueDTO {

    private Long id;
    private String value;
    private FeatureTypeDTO type;
}
