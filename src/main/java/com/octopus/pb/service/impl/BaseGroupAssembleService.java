package com.octopus.pb.service.impl;


import com.octopus.pb.model.Group;
import com.octopus.pb.model.Player;
import com.octopus.pb.service.GroupAssembleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("groupAssembleService")
public class BaseGroupAssembleService implements GroupAssembleService {

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
