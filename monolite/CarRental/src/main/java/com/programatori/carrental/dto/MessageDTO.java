package com.programatori.carrental.dto;

import com.programatori.carrental.models.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private Long id;

    private String subject;

    private String content;

    private String sendDate;

    private Long rentalRequest;

    private MessageStatus status;

    private UserDTO sender;

    private UserDTO receiver;
}
