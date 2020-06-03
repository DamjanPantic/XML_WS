package com.programatori.carservice.dto;

import com.programatori.carservice.models.User;
import lombok.Data;

@Data
public class UserDTO {

    private String email;
    private String username;

    public UserDTO(User user) {
        this.email = user.getEmail();
        this.username = user.getUsername();
    }
}
