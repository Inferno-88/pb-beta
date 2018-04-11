package com.octopus.pb.service;


import com.octopus.pb.dto.GroupDto;
import com.octopus.pb.dto.PlayerDto;
import com.octopus.pb.entity.Group;

import java.util.List;
import java.util.Set;


public interface GroupService {

    //Core methods
    Set<PlayerDto> getPlayersFromGroup(int groupId);

    GroupDto putPlayerToGroup(int groupId, int playerId);

    GroupDto removePlayerFromGroup(int groupId, int playerId);

//    GroupDto putPlayerToGroup(GroupDto groupDto, PlayerDto playerDto);
//
//    GroupDto removePlayerFromGroup(GroupDto groupDto, PlayerDto playerDto);

    //Repository methods
    Group saveGroup(Group group);

    boolean deleteGroup(Group group);

    Group getGroup(Group group);

    List<Group> findAll();

}
