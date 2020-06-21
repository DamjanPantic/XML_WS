package com.programatori.recensionservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "grade_recension_service")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long vehicleId;

    @Column(nullable = false)
<<<<<<< Updated upstream
    private Double gradeValue;
=======
    private Integer gradeValue;
>>>>>>> Stashed changes

    @Column(nullable = false)
    private Long userId;

    public Grade(){}



}
