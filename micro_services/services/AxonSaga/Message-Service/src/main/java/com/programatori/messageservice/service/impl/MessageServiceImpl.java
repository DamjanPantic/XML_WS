package com.programatori.messageservice.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programatori.messageservice.client.RentalClient;
import com.programatori.messageservice.dto.MessageDTO;
import com.programatori.messageservice.dto.RentalRequestDTO;
import com.programatori.messageservice.models.Message;
<<<<<<< Updated upstream
import com.programatori.messageservice.models.MessageStatus;
=======
>>>>>>> Stashed changes
import com.programatori.messageservice.repository.MessageRepository;
import com.programatori.messageservice.service.MessageService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
=======
import java.text.SimpleDateFormat;
>>>>>>> Stashed changes

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    RentalClient rentalClient;

    DozerBeanMapper dozerMapper = new DozerBeanMapper();

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public ResponseEntity<?> sendMessage(MessageDTO messageDTO) throws ParseException {
        ResponseEntity<?> responseEntity = rentalClient.getRentalRequestById(messageDTO.getRequestId());
        RentalRequestDTO rentalRequestDTO = mapper.convertValue(responseEntity.getBody(),new TypeReference<RentalRequestDTO>() {});
        System.out.println(rentalRequestDTO.getStatus());
        if( rentalRequestDTO.getStatus().equals("RESERVED")){
<<<<<<< Updated upstream
            messageDTO.setSendDate(null);
            Message message = dozerMapper.map(messageDTO,Message.class);
            message.setSendDate(new Date());
            message.setStatus(MessageStatus.DELIVERED);
            messageRepository.save(message);

            List<MessageDTO> messages = new ArrayList<>();

            for (Message messageTemp: messageRepository.findByRequestId(messageDTO.getRequestId())) {
                messages.add(dozerMapper.map(messageTemp, MessageDTO.class));
            }

            return new ResponseEntity<>(messages, HttpStatus.OK);
=======
            System.out.println("USAO U IF");
            String sentDateString = messageDTO.getSendDate();
            messageDTO.setSendDate(null);
            Message message = dozerMapper.map(messageDTO,Message.class);
            message.setSendDate(new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(sentDateString));
            messageRepository.save(message);
            System.out.println("ZAVRSIO IF");
            return new ResponseEntity<>(message, HttpStatus.OK);
>>>>>>> Stashed changes
        }

        return new ResponseEntity<>("Rental request has to be RESERVED", HttpStatus.BAD_REQUEST);



    }
<<<<<<< Updated upstream

    @Override
    public List<MessageDTO> getRequestConversation(Long requestId) {
        List<MessageDTO> messages = new ArrayList<>();

        for (Message message: messageRepository.findByRequestId(requestId)) {
            messages.add(dozerMapper.map(message, MessageDTO.class));
        }

        return messages;
    }
=======
>>>>>>> Stashed changes
}
