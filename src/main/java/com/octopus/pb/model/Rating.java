package com.octopus.pb.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = "field")
@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int positive;
    private int negative;

    //Parameters with 1 to 5 stars, e.g. playing field quality, etc.

    @OneToOne(mappedBy = "rating")
    private Field field;

}
