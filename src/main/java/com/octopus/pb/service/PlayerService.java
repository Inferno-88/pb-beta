package com.octopus.pb.service;

import com.octopus.pb.model.Player;

import java.util.List;

public interface PlayerService {

    Player savePlayer(Player player);

    Player getPlayer(Player player);

    void deletePlayer(Player player);

    List<Player> getPlayerList();

}
