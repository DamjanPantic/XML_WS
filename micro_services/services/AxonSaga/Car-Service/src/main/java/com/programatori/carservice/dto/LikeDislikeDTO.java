package com.programatori.carservice.dto;

import com.programatori.carservice.models.LikeDislike;
import lombok.Data;

@Data
public class LikeDislikeDTO {

    private Long id;
    private Boolean liked;
    private UserDTO user;

    public LikeDislikeDTO(){}

    public LikeDislikeDTO(LikeDislike likeDislike) {
        this.liked = likeDislike.getLiked();
        this.user = new UserDTO(likeDislike.getUser());
    }
}
