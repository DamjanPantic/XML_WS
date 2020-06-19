package com.programatori.messageservice.service;

import com.programatori.messageservice.dto.MessageDTO;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface MessageService {
        public ResponseEntity<?> sendMessage(MessageDTO messageDTO) throws ParseException;
}
