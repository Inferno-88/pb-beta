package com.octopus.pb.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.octopus.pb.enums.RankType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"playerSet", "teamSet"})
public class RankDto {

    private int id;
    private String name;
    private RankType rankType;

    @JsonIgnore
    private Set<PlayerDto> playerSet;
    @JsonIgnore
    private Set<TeamDto> teamSet;

}
