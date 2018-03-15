package com.octopus.pb.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldDto {

    private int id;
    private String name;
    private String fieldInfo; //TODO fieldDetails object with fieldInfo, capacity, size, type, etc.
    private String address;
    private int capacity;
    private RatingDto ratingDto;

//    private final Set<Event> eventSet = new HashSet<>();
//    private final Set<Photo> photoSet = new HashSet<>();

}
