package com.programatori.recensionservice.service;

import com.programatori.recensionservice.dto.CommentDTO;
import com.programatori.recensionservice.models.Comment;
import com.programatori.recensionservice.models.CommentStatus;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {

    public ResponseEntity<?> addComment(Comment comment);
    public ResponseEntity<?> getCommentsByStatus(CommentStatus status);
    public ResponseEntity<?> approveComment(Long id);
    public ResponseEntity<?> declineComment(Long id);


    List<CommentDTO> getVehicleComments(Long vehicleId);
}
