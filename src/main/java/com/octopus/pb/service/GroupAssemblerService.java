package com.octopus.pb.service;


import com.octopus.pb.model.Group;
import com.octopus.pb.model.Player;

import java.util.List;


public interface GroupAssemblerService {

    //Core methods
    List<Player> getPlayersFromGroup(Group group);

    Group putPlayerToGroup(Player player);

    //Repository methods
    Group saveGroup(Group group);

    void deleteGroup(Group group);

    Group getGroup(Group group);

    List<Group> findAll();

}
