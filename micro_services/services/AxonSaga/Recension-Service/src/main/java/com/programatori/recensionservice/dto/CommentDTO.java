package com.programatori.recensionservice.dto;

import com.programatori.recensionservice.models.CommentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentDTO {

    private Long id;
    private VehicleBasicDTO vehicleId;
    private String content;
    private UserDTO userId;
    private CommentStatus commentStatus;
}
