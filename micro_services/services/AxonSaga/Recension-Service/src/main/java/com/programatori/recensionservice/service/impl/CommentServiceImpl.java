package com.programatori.recensionservice.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programatori.recensionservice.client.RentalClient;
import com.programatori.recensionservice.client.UsersClient;
import com.programatori.recensionservice.client.VehicleClient;
import com.programatori.recensionservice.dto.CommentDTO;
import com.programatori.recensionservice.dto.UserDTO;
import com.programatori.recensionservice.dto.VehicleBasicDTO;
import com.programatori.recensionservice.models.Comment;
import com.programatori.recensionservice.models.CommentStatus;
import com.programatori.recensionservice.repository.CommentRepository;
import com.programatori.recensionservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    RentalClient rentalClient;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UsersClient usersClient;

    @Autowired
    VehicleClient vehicleClient;

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public ResponseEntity<?> addComment(Comment comment) {

        Boolean exist = rentalClient.getRentalRequestByParams(comment.getUserId(),comment.getVehicleId());
        if(!exist)
            return new ResponseEntity<>("You cant comment this vehicle", HttpStatus.BAD_REQUEST);

        comment.setCommentStatus(CommentStatus.PENDING);
        commentRepository.save(comment);
        return new ResponseEntity<>(comment,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> getCommentsByStatus(CommentStatus status) {
        List<Comment> comments = commentRepository.findAllByCommentStatus(status);
        if(comments == null)
            return new ResponseEntity<>("Comments doesn't exist",HttpStatus.BAD_REQUEST);
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment comment : comments){
            ResponseEntity<?> responseEntity = usersClient.getUserById(comment.getUserId());
            UserDTO userDTO = mapper.convertValue(responseEntity.getBody(), new TypeReference<UserDTO>() {});
            ResponseEntity<?> responseEntity1 = vehicleClient.getVehicleModelById(comment.getVehicleId());
            VehicleBasicDTO vehicleBasicDTO = mapper.convertValue(responseEntity1.getBody(),
                    new TypeReference<VehicleBasicDTO>() {});
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setId(comment.getId());
            commentDTO.setUserId(userDTO);
            commentDTO.setVehicleId(vehicleBasicDTO);
            commentDTO.setContent(comment.getContent());
            commentDTO.setCommentStatus(comment.getCommentStatus());
            commentDTOS.add(commentDTO);


        }

        return new ResponseEntity<>(commentDTOS,HttpStatus.OK);
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


}
