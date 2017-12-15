package com.octopus.pb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int positive;
    private int negative;

    @OneToOne(mappedBy = "rating")
    private Field field;

}
