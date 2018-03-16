package com.octopus.pb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EventDto {

    private int id;
    private String name;
    private String info;
    private String shortInfo;
    private String gameRules;
    private int capacity;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private boolean isActive;

    private FieldDto field;

//    private final Map<GroupType, Group> groupMap = new HashMap<>();
//    private final Set<Photo> photoSet = new HashSet<>();

}
