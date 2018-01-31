package com.octopus.pb.controller;


import com.octopus.pb.enums.GroupType;
import com.octopus.pb.enums.PhotoType;
import com.octopus.pb.enums.RankType;
import com.octopus.pb.model.*;
import com.octopus.pb.repository.EventRepository;
import com.octopus.pb.repository.GroupRepository;
import com.octopus.pb.repository.PlayerRepository;
import com.octopus.pb.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TestController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    GroupRepository groupRepository;


    @GetMapping("/test")
    private void test() {

        Rank playerRank = new Rank("First", RankType.PLAYER);
        Rank teamRank = new Rank("TeamRank", RankType.PLAYER);

        Player player = new Player("Player1");

        Team team = new Team("Team1");
        team.setRank(teamRank);

        player.setTeam(team);
        player.setRank(playerRank);

        Photo playerPhoto = new Photo("Photo/URL/1", PhotoType.PLAYER);

        player.getPhotoSet().add(playerPhoto);

        playerRepository.save(player);

        playerRank.equals(playerRepository.findOne(1L).getName());

    }

    @GetMapping("/event")
    private void testGroup() {

        Player player1 = new Player("One");
        Player player2 = new Player("Two");
        Player player3 = new Player("Three");
        Player player4 = new Player("Four");
        Player player5 = new Player("Five");

        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("One"));
        playerList.add(new Player("Two"));
        playerList.add(new Player("Three"));
        playerList.add(new Player("Four"));
        playerList.add(new Player("Five"));

        playerRepository.save(playerList);

        Team team1 = new Team("FirstTeam");
        Team team2 = new Team("SecondTeam");

        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team2.addPlayer(player3);
        team2.addPlayer(player4);

        teamRepository.save(team1);
        teamRepository.save(team2);

        Event event1 = new Event("FirstEvent");

        Group group1 = new Group(GroupType.RED, event1);
        Group group2 = new Group(GroupType.BLUE, event1);

        Field field1 = new Field("FirstField");

        group1.addPlayer(player1);
        group1.addPlayer(player2);
        group1.addPlayer(player3);
        group2.addPlayer(player4);
        group2.addPlayer(player5);

        event1.getGroupSet().put(group1.getGroupType(), group1);
        event1.getGroupSet().put(group2.getGroupType(), group2);

        event1.setField(field1);

        eventRepository.save(event1);
    }

}
