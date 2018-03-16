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
    private int surfaceQuality;
    private int coverAmount;
    private int coverQuality;
    private int coverPlacement;
    private int infrastructure;
    private int staff;
    private int rentalEquipment;
    private int prices;

    @OneToOne(mappedBy = "rating")
    private Field field;

    public Rating() {
    }

    public Rating(Field field) {
        this.field = field;
    }

}
