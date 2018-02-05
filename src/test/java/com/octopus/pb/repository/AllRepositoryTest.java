package com.octopus.pb.repository;


import com.octopus.pb.enums.GroupType;
import com.octopus.pb.model.Event;
import com.octopus.pb.model.Group;
import com.octopus.pb.model.Player;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class AllRepositoryTest {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testContextLoader() {
        assertTrue(8 == 8);
    }

//    @Test
//    public void testGroupRepo() {
//
//        Player player1 = new Player("One");
//        Event event1 = new Event("FirstEvent");
//
//        Group group1 = new Group(GroupType.RED);
//        group1.addPlayer(player1);
//
//        event1.addGroup(group1);
//
//        Group save = groupRepository.save(group1);
//
//        assertNotNull(save);
//
//        assertTrue(playerRepository.findAll().size() > 0);
//
//        System.out.println("lol");
//    }

    @Test
    public void testGetPlayer() {

        Player player = playerRepository.findOne(1);

        assertEquals(player.getName(), "SpringData insert Player_1");
    }

}
