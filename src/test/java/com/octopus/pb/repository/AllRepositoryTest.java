package com.octopus.pb.repository;


import com.octopus.pb.enums.*;
import com.octopus.pb.model.*;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Slf4j
public class AllRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RankRepository rankRepository;


    @Test
    public void testContextLoader() {
        assertTrue(8 == 8);
    }

    @Test
    public void testPlayerSave() {

        List<Player> playerList1 = new ArrayList<>();
        playerList1.add(new Player("One"));
        playerList1.add(new Player("Two"));
        playerList1.add(new Player("Three"));

        List<Player> playerList2 = new ArrayList<>();
        playerList2.add(new Player("Four"));
        playerList2.add(new Player("Five"));

        List<Player> savedList1 = playerRepository.save(playerList1);
        List<Player> savedList2 = playerRepository.save(playerList2);

        assertTrue("SavedList1 size is not 3", savedList1.size() == 3);
        assertTrue("SavedList2 size is not 2", savedList2.size() == 2);
    }

    @Test
    public void testPlayerGet() {

        Player player1 = playerRepository.findOne(1);
        Player player2 = playerRepository.findOne(2);
        Player player3 = playerRepository.findOne(3);
        Player player88 = playerRepository.findOne(88);

        assertEquals("Player1 name does not match", player1.getName(), "inserted_player_1");
        assertEquals("Player2 name does not match", player2.getName(), "inserted_player_2");
        assertEquals("Player3 name does not match", player3.getName(), "inserted_player_3");
        assertEquals("Player88 name does not match", player88.getName(), "inserted_player_88");
    }

    @Test
    public void testTeamSave() {

        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");

        Team savedTeam1 = teamRepository.save(team1);
        Team savedTeam2 = teamRepository.save(team2);

        assertEquals("SavedTeam1 name does not match", savedTeam1.getName(), "Team1");
        assertEquals("SavedTeam2 name does not match", savedTeam2.getName(), "Team2");
    }

    @Test
    public void testEventSave() {

        Event event1 = new Event("FirstEvent");

        Group group1 = new Group(GroupType.RED);
        Group group2 = new Group(GroupType.BLUE);

        List<Group> groupList = new ArrayList<>();
        groupList.add(group1);
        groupList.add(group2);

        event1.addGroupList(groupList);

        eventRepository.save(event1);
    }

    @Test
    public void testRankRepo() {
        //Constraints tests
    }

}
