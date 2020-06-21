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

<<<<<<< Updated upstream
import java.util.List;

=======
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    @Override
    public ResponseEntity<?> getCommentsByStatus(CommentStatus status) {
        List<Comment> comments = commentRepository.findAllByCommentStatus(status);
        if(comments == null)
            return new ResponseEntity<>("Comments doesn't exist",HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(comments,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> approveComment(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment == null)
            return new ResponseEntity<>("Comment doesn't exist",HttpStatus.BAD_REQUEST);

        comment.setCommentStatus(CommentStatus.APPROVED);
        commentRepository.save(comment);
        return new ResponseEntity<>(comment,HttpStatus.OK);


    }

    @Override
    public ResponseEntity<?> declineComment(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment == null)
            return new ResponseEntity<>("Comment doesn't exist",HttpStatus.BAD_REQUEST);

        comment.setCommentStatus(CommentStatus.DENIED);
        commentRepository.save(comment);
        return new ResponseEntity<>(comment,HttpStatus.OK);
    }

=======
>>>>>>> Stashed changes
}
