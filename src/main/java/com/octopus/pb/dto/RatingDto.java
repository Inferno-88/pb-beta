package com.octopus.pb.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class RatingDto {

    private int id;
    private int positive;
    private int negative;

    @JsonIgnore
    private FieldDto field;

}
