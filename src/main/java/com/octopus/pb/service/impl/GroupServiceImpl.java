package com.octopus.pb.service.impl;


import com.octopus.pb.entity.Group;
import com.octopus.pb.entity.Player;
import com.octopus.pb.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("groupAssemblerService")
public class GroupServiceImpl implements GroupService {

    @Override
    public List<Player> getPlayersFromGroup(Group group) {
        return null;
    }

    @Override
    public Group putPlayerToGroup(Player player) {
        return null;
    }

    @Override
    public Group saveGroup(Group group) {
        return null;
    }

    @Override
    public void deleteGroup(Group group) {

    }

    @Override
    public Group getGroup(Group group) {
        return null;
    }

    @Override
    public List<Group> findAll() {
        return null;
    }

}
