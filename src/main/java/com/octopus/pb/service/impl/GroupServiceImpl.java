package com.octopus.pb.service.impl;


import com.octopus.pb.dto.GroupDto;
import com.octopus.pb.dto.PlayerDto;
import com.octopus.pb.entity.Group;
import com.octopus.pb.entity.Player;
import com.octopus.pb.manager.Mediator;
import com.octopus.pb.mapper.CycleAvoidContext;
import com.octopus.pb.mapper.DtoMapper;
import com.octopus.pb.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service("groupAssemblerService")
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final Mediator mediator;
    private final DtoMapper dtoMapper;
    private final CycleAvoidContext cycleAvoidContext;


    @Override
    public Set<PlayerDto> getPlayersFromGroup(int groupId) {
        Group group = (Group) mediator.getRepo("Group").findOne(groupId);

        return group.getPlayerSet().stream()
                .map(e -> dtoMapper.entityToDto(e, cycleAvoidContext))
                .collect(Collectors.toSet());
    }

    @Override
    public GroupDto putPlayerToGroup(int groupId, int playerId) {
        Group group = (Group) mediator.getRepo("Group").findOne(groupId);
        Player player = (Player) mediator.getRepo("Player").findOne(playerId);

        group.addPlayer(player);
        group = (Group) mediator.getRepo("Group").save(group);

        return dtoMapper.entityToDto(group, cycleAvoidContext);
    }

    @Override
    public GroupDto removePlayerFromGroup(int groupId, int playerId) {
        return null;
    }

    @Override
    public Group saveGroup(Group group) {
        return null;
    }

    @Override
    public boolean deleteGroup(Group group) {
        return false;
    }

    @Override
    public Group getGroup(Group group) {
        return null;
    }

    @Override
    public List<Group> findAll() {
        return null;
    }

    private Player getPlayerInGroup(Group group, int playerId) {
        return group.getPlayerSet().stream()
                .filter(p -> p.getId() == playerId)
                .findFirst()
                .get();
    }

}

