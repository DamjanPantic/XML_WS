package com.programatori.recensionservice.controller;

import com.programatori.recensionservice.models.Comment;
import com.programatori.recensionservice.models.CommentStatus;
import com.programatori.recensionservice.models.Grade;
import com.programatori.recensionservice.service.CommentService;
import com.programatori.recensionservice.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class RecensionController {

    @Autowired
    GradeService gradeService;

    @Autowired
    CommentService commentService;

    @GetMapping("/hello")
    public ResponseEntity<?> get() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        return new ResponseEntity<>(String.format("Hello from Recension service with ip address %s!", ip), HttpStatus.OK);
    }

    @GetMapping(path = "/comments/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCommentsByStatus(@PathVariable CommentStatus status){
        return commentService.getCommentsByStatus(status);
    }

    @GetMapping(path = "/rating/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRating(@PathVariable Long id){
        return gradeService.getVehicleRating(id);
    }

    @GetMapping(path = "/grade/{vehicleId}/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGradeByUser(@PathVariable Long vehicleId,@PathVariable Long userId){
        return gradeService.getVehicleGradeByUser(vehicleId,userId);
    }

    @PostMapping(path = "/comment/approve/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> approveComment(@PathVariable Long id){
        return commentService.approveComment(id);
    }

    @PostMapping(path = "/comment/decline/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> declineComment(@PathVariable Long id){
        return commentService.declineComment(id);
    }

    @PostMapping(path = "/add-grade", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addGrade(@RequestBody Grade grade){
            return gradeService.addGrade(grade);
    }

    @PostMapping(path = "/add-comment", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @GetMapping(path = "/vehicle/comments/{vehicleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getVehiclesComments(@PathVariable Long vehicleId){
        return new ResponseEntity<>(commentService.getVehicleComments(vehicleId), HttpStatus.OK);
    }
}
