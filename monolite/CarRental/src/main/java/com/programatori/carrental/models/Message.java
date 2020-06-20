package com.programatori.carrental.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Date sendDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private RentalRequest rentalRequest;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageStatus status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private User receiver;

    public Message(){}
}