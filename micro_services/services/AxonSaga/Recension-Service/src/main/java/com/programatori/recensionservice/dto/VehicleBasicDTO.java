package com.programatori.recensionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleBasicDTO {
    private Long id;
    private ModelDTO model;
}
