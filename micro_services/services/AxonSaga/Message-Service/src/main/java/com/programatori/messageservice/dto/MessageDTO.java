package com.programatori.messageservice.dto;

import com.programatori.messageservice.models.MessageStatus;
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

    private Long requestId;

    private MessageStatus status;

    private Long senderId;

    private Long receiverId;
}
