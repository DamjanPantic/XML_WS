package com.programatori.carrental.controller;

import com.programatori.carrental.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getVehicleCommentsForUser(@PathVariable Long id){

        return commentService.getVehicleCommentsForUser(id);
    }
}
