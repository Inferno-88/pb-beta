package com.octopus.pb.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"eventSet", "photoSet"})
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
    private Set<PhotoDto> photoSet;

}
