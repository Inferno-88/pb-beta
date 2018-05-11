package com.octopus.pb.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"playerSet", "photoSet"})
public class TeamDto {

    private int id;
    private String name;
    private String shortName;
    private String teamInfo;
    private RankDto rank;

    @JsonIgnore
    private Set<PlayerDto> playerSet;
    private Set<PhotoDto> photoSet;

}
