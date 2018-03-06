package com.octopus.pb.service;

import com.octopus.pb.entity.Player;

import java.util.List;

public interface PlayerService {

    //Core methods


    //Repository methods
    Player savePlayer(Player player);

    Player getPlayer(Player player);

    void deletePlayer(Player player);

    List<Player> getPlayerList();

}
