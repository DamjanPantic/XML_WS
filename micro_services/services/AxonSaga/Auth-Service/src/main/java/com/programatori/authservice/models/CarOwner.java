package com.programatori.authservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.DiscriminatorType.STRING;

@Getter
@Setter
@Entity
@DiscriminatorColumn(name="owner_type", discriminatorType=STRING)
@DiscriminatorValue("owner")
public class CarOwner extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
