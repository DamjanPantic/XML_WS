package com.programatori.messageservice.controller;

import com.programatori.messageservice.dto.MessageDTO;
import com.programatori.messageservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

>>>>>>> Stashed changes

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

<<<<<<< Updated upstream
    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
=======
    @PostMapping(path = "/send", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
>>>>>>> Stashed changes
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO messageDTO) throws ParseException {
        return messageService.sendMessage(messageDTO);
    }

<<<<<<< Updated upstream
    @GetMapping(path = "/{requestId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getConversation(@PathVariable Long requestId){
        List<MessageDTO> messages = messageService.getRequestConversation(requestId);
        return new ResponseEntity<>(messages, HttpStatus.OK);
=======
    @GetMapping(path = "/send")
    public ResponseEntity<?> asd(){
        return new ResponseEntity<>("asdsadada", HttpStatus.OK);
>>>>>>> Stashed changes
    }
}
