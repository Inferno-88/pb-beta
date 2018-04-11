package com.octopus.pb.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"user", "groupSet", "photoSet"})
public class PlayerDto {

    private int id;
    private String name;
    private RankDto rank;
    private TeamDto team;

//    private UserDto user;

    @JsonIgnore
    private Set<GroupDto> groupSet;
    private Set<PhotoDto> photoSet;

}
