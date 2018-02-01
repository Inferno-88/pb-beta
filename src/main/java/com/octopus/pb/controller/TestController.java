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

        Rank playerRank = new Rank("PlayerRank", RankType.PLAYER);
        Rank teamRank = new Rank("TeamRank", RankType.TEAM);

        Player player = new Player("Player1");

        Team team = new Team("Team1");
        team.setRank(teamRank);

        player.setTeam(team);
        player.setRank(playerRank);

        Photo playerPhoto = new Photo("Photo/URL/1", PhotoType.PLAYER);

        player.getPhotoSet().add(playerPhoto);

        playerRepository.save(player);

        //playerRank.equals(playerRepository.findOne(1L).getName());
    }

    @GetMapping("/event")
    private void testEvent() {

        List<Player> playerList1 = new ArrayList<>();
        playerList1.add(new Player("One"));
        playerList1.add(new Player("Two"));
        playerList1.add(new Player("Three"));

        List<Player> playerList2 = new ArrayList<>();
        playerList2.add(new Player("Four"));
        playerList2.add(new Player("Five"));

        playerRepository.save(playerList1);
        playerRepository.save(playerList2);

        Event event1 = new Event("FirstEvent");

        List<Group> groupList = new ArrayList<>();
        Group group1 = new Group(GroupType.RED, event1);
        Group group2 = new Group(GroupType.BLUE, event1);
        groupList.add(group1);
        groupList.add(group2);

        event1.addGroupList(groupList);

        //group1.addPlayerList(playerList1);
        //group2.addPlayerList(playerList2);

        groupRepository.save(groupList);
//
//        Field field1 = new Field("FirstField");
//        event1.setField(field1);
//
//        eventRepository.save(event1);
    }

    @GetMapping("/group")
    public void testGroup() {

//        List<Player> playerList1 = new ArrayList<>();
//        playerList1.add(new Player("One"));
//        playerList1.add(new Player("Two"));
//        playerList1.add(new Player("Three"));

        //playerRepository.save(playerList1);

        Player player1 = new Player("One");

        Group group1 = new Group(GroupType.RED, new Event("FirstEvent"));
        group1.addPlayer(player1);
        
        groupRepository.save(group1);
    }

}
