package com.octopus.pb.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.octopus.pb.enums.PhotoType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PhotoDto {

    private int id;
    private String path;
    private PhotoType photoType;
    @JsonIgnore
    private Set<PlayerDto> playerSet;
    @JsonIgnore
    private Set<TeamDto> teamSet;
    @JsonIgnore
    private Set<FieldDto> fieldSet;
    @JsonIgnore
    private Set<EventDto> eventSet;

}
