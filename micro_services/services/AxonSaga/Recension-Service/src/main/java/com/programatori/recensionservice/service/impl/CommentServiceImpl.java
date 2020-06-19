package com.programatori.recensionservice.service.impl;

import com.programatori.recensionservice.client.RentalClient;
import com.programatori.recensionservice.models.Comment;
import com.programatori.recensionservice.models.CommentStatus;
import com.programatori.recensionservice.repository.CommentRepository;
import com.programatori.recensionservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    RentalClient rentalClient;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public ResponseEntity<?> addComment(Comment comment) {

        Boolean exist = rentalClient.getRentalRequestByParams(comment.getUserId(),comment.getVehicleId());
        if(!exist)
            return new ResponseEntity<>("You cant comment this vehicle", HttpStatus.BAD_REQUEST);

        comment.setCommentStatus(CommentStatus.PENDING);
        commentRepository.save(comment);
        return new ResponseEntity<>(comment,HttpStatus.OK);

    }

}
