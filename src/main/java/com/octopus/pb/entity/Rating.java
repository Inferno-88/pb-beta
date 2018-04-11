package com.octopus.pb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
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

    @JsonIgnore
    @OneToOne(mappedBy = "rating")
    private Field field;

}
