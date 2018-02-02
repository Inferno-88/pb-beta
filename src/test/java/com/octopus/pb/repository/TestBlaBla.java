package com.octopus.pb.repository;

import com.octopus.pb.enums.GroupType;
import com.octopus.pb.model.Event;
import com.octopus.pb.model.Group;
import com.octopus.pb.model.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestBlaBla {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PlayerRepository playerRepository;

//    @Autowired
//    private TestEntityManager testEntityManager;

    @Test
    public void testContextLoader() {
        assertTrue(1 == 1);
    }

    @Test
    public void testGroupRepo() {

        Player player1 = new Player("One");
        Event event1 = new Event("FirstEvent");

        Group group1 = new Group(GroupType.RED);
        group1.addPlayer(player1);

        event1.addGroup(group1);

//        Group persist = testEntityManager.persist(group1);
//        testEntityManager.flush();

        Group save = groupRepository.save(group1);

        assertNotNull(save);

        assertTrue(playerRepository.findAll().size() > 0);

        System.out.println("lol");
    }

}
