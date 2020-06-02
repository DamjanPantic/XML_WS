package com.programatori.authservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DiscriminatorValue("company")
public class Company extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
