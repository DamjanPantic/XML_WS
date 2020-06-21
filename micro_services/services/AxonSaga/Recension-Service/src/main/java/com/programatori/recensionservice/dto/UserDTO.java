package com.programatori.recensionservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
}
