package com.octopus.pb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.octopus.pb.enums.GroupType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroupDto {

    private int id;
    private GroupType groupType;

    @JsonIgnore
    private EventDto event;

//    private final Set<PlayerDto> playerSet;

}
