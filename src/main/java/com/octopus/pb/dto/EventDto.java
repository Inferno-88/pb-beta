package com.octopus.pb.dto;

import com.octopus.pb.enums.GroupType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"groupMap", "photoSet"})
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
    private Map<GroupType, GroupDto> groupMap;

//    private Set<Photo> photoSet;

}
