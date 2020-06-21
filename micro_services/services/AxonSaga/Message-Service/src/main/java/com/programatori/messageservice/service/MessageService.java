package com.programatori.messageservice.service;

import com.programatori.messageservice.dto.MessageDTO;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
<<<<<<< Updated upstream
import java.util.List;

public interface MessageService {
        public ResponseEntity<?> sendMessage(MessageDTO messageDTO) throws ParseException;

    List<MessageDTO> getRequestConversation(Long requestId);
=======

public interface MessageService {
        public ResponseEntity<?> sendMessage(MessageDTO messageDTO) throws ParseException;
>>>>>>> Stashed changes
}
