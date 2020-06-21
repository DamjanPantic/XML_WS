package com.programatori.carrental.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programatori.carrental.dto.MessageDTO;
import com.programatori.carrental.models.Message;
import com.programatori.carrental.models.MessageStatus;
import com.programatori.carrental.models.RentalRequest;
import com.programatori.carrental.repository.MessageRepository;
import com.programatori.carrental.repository.RentalRequestRepository;
import com.programatori.carrental.service.MessageService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    RentalRequestRepository rentalRequestRepository;

    DozerBeanMapper dozerMapper = new DozerBeanMapper();

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public ResponseEntity<?> sendMessage(MessageDTO messageDTO) throws ParseException {
        RentalRequest rentalRequest = rentalRequestRepository.findById(messageDTO.getRentalRequest()).orElse(null);

        if(rentalRequest == null)
            return new ResponseEntity<>("Rental request does not exist", HttpStatus.BAD_REQUEST);


        if( rentalRequest.getStatus().equals("RESERVED")){
            messageDTO.setSendDate(null);
            Message message = dozerMapper.map(messageDTO,Message.class);
            message.setSendDate(new Date());
            message.setStatus(MessageStatus.DELIVERED);
            messageRepository.save(message);

            List<MessageDTO> messages = new ArrayList<>();

            for (Message messageTemp: messageRepository.findByRentalRequest(rentalRequest)) {
                messages.add(dozerMapper.map(messageTemp, MessageDTO.class));
            }
            return new ResponseEntity<>(messages, HttpStatus.OK);
        }

        return new ResponseEntity<>("Rental request has to be RESERVED", HttpStatus.BAD_REQUEST);


    }

    @Override
    public List<MessageDTO> getRequestConversation(Long requestId) {
        RentalRequest rentalRequest = rentalRequestRepository.findById(requestId).orElse(null);

        List<MessageDTO> messages = new ArrayList<>();

        for (Message message: messageRepository.findByRentalRequest(rentalRequest)) {
            messages.add(dozerMapper.map(message, MessageDTO.class));
        }

        return messages;
    }
}
