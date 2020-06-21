package com.programatori.carrental.service;

import com.programatori.carrental.dto.MessageDTO;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface MessageService {

    public ResponseEntity<?> sendMessage(MessageDTO messageDTO) throws ParseException;
    public List<MessageDTO> getRequestConversation(Long requestId);
}
