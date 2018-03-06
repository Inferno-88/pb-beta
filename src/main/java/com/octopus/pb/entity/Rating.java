package com.octopus.pb.entity;

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

    //TODO
    //Main parameters with 1 to 5 stars, e.g. surface quality, cover quality, cover amount, shooting distances, field paint quality, price
    //Sub parameters with 1 to 5 stars, e.g. rental equipment quality, infrastructure, staff

    @OneToOne(mappedBy = "rating")
    private Field field;

    public Rating() {
    }

    public Rating(Field field) {
        this.field = field;
    }

}
