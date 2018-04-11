package com.octopus.pb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.octopus.pb.enums.GroupType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "playerSet")
public class GroupDto {

    private int id;
    private GroupType groupType;

    @JsonIgnore
    private EventDto event;
    private Set<PlayerDto> playerSet;

}
