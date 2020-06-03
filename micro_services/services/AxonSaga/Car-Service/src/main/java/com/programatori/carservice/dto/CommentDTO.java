package com.programatori.carservice.dto;

import com.programatori.carservice.models.Comment;
import lombok.Data;

@Data
public class CommentDTO {

    private String comment;
    private UserDTO user;

    public CommentDTO(Comment comment) {
        this.comment = comment.getComment();
        this.user = new UserDTO(comment.getUser());
    }
}
