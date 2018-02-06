package com.octopus.pb.repository;


import com.octopus.pb.enums.GroupType;
import com.octopus.pb.model.Event;
import com.octopus.pb.model.Group;
import com.octopus.pb.model.Player;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Slf4j
public class AllRepositoryTest {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RankRepository rankRepository;


    @Test
    public void testContextLoader() {
        assertTrue(8 == 8);
    }

    @Test
    public void testGroupRepo() {

        Player player1 = new Player("One");
        Event event1 = new Event("FirstEvent");

        Group group1 = new Group(GroupType.RED);
        group1.addPlayer(player1);

        event1.addGroup(group1);

        Group save = groupRepository.save(group1);

        assertNotNull(save);

        assertTrue(playerRepository.findAll().size() > 0);

        log.info("lol");
    }

    @Test
    public void testPlayerRepo() {

        Player player1 = playerRepository.findOne(1);
        Player player2 = playerRepository.findOne(2);
        Player player3 = playerRepository.findOne(3);
        Player player88 = playerRepository.findOne(88);

        log.info(player1.getName());
        log.info(player2.getName());
        log.info(player3.getName());
        log.info(player88.getName());

        assertEquals(player1.getName(), "inserted_player_1");
        assertEquals(player2.getName(), "inserted_player_2");
        assertEquals(player3.getName(), "inserted_player_3");
        assertEquals(player88.getName(), "inserted_player_88");
    }

    @Test
    public void testTeamRepo() {
        //Cascade tests
    }

    @Test
    public void testEventRepo() {
        //Cascade tests
    }

    @Test
    public void testRankRepo() {
        //Constraints tests
    }
    
}
