package com.programatori.carrental.service.impl;

import com.programatori.carrental.models.Comment;
import com.programatori.carrental.models.CommentStatus;
import com.programatori.carrental.repository.CommentRepository;
import com.programatori.carrental.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public ResponseEntity<?> getVehicleCommentsForUser(Long id) {
        List<Comment> comments = commentRepository.getVehicleCommentsForUser(id, CommentStatus.APPROVED);
        if(comments == null)
            return new ResponseEntity<>("comments null", HttpStatus.BAD_REQUEST);


        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
