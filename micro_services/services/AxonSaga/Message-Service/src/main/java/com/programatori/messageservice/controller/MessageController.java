package com.programatori.messageservice.controller;

import com.programatori.messageservice.dto.MessageDTO;
import com.programatori.messageservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO messageDTO) throws ParseException {
        return messageService.sendMessage(messageDTO);
    }

    @GetMapping(path = "/{requestId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getConversation(@PathVariable Long requestId) {
        List<MessageDTO> messages = messageService.getRequestConversation(requestId);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
