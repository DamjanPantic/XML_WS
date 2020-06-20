package com.programatori.messageservice.controller;

import com.programatori.messageservice.dto.MessageDTO;
import com.programatori.messageservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping(path = "/send", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO messageDTO) throws ParseException {
        return messageService.sendMessage(messageDTO);
    }

    @GetMapping(path = "/send")
    public ResponseEntity<?> asd(){
        return new ResponseEntity<>("asdsadada", HttpStatus.OK);
    }
}
