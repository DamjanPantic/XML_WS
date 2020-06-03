package com.programatori.carservice.dto;

import com.programatori.carservice.models.User;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String username;

    public UserDTO(){

    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }
}
