package com.programatori.carrental.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Vehicle vehicle;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CommentStatus commentStatus;

    public Comment(){}


}
