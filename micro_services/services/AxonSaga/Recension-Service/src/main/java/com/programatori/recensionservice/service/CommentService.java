package com.programatori.recensionservice.service;

import com.programatori.recensionservice.models.Comment;
import org.springframework.http.ResponseEntity;

public interface CommentService {

    public ResponseEntity<?> addComment(Comment comment);

}
