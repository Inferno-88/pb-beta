package com.octopus.pb.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
public class FieldDto {

    private int id;
    private String name;
    private String info;
    private String type;
    private String size;
    private int capacity;
    private String address;
    private RatingDto rating;

    @JsonIgnore
    private Set<EventDto> eventSet;
//    private final Set<Photo> photoSet = new HashSet<>();

}
