package com.octopus.pb.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "field")
public class RatingDto {

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
    private FieldDto field;

}
