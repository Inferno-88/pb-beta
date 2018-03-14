package com.octopus.pb.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventDto {

    private int id;
    private String name;
    private String eventInfo;
    private String gameRules;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private boolean isActive;
//    private FieldDto field;

//    private final Map<GroupType, Group> groupMap = new HashMap<>();
//    private final Set<Photo> photoSet = new HashSet<>();

}
