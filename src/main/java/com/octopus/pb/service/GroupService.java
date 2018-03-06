package com.octopus.pb.service;


import com.octopus.pb.entity.Group;
import com.octopus.pb.entity.Player;

import java.util.List;


public interface GroupService {

    //Core methods
    List<Player> getPlayersFromGroup(Group group);

    Group putPlayerToGroup(Player player);

    //Repository methods
    Group saveGroup(Group group);

    void deleteGroup(Group group);

    Group getGroup(Group group);

    List<Group> findAll();

}
