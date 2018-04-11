package com.octopus.pb.service;


import com.octopus.pb.dto.PlayerDto;
import com.octopus.pb.entity.Event;
import com.octopus.pb.testdata.BuildData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Slf4j
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/db-wipe.sql")
public class GroupServiceTest {

    @Autowired
    private BuildData buildData;

    @Autowired
    private GroupService groupService;


    @Test
    @Transactional
    public void testGroupSerice() {

        Event event = buildData.buildEvent();
        Set<PlayerDto> playerDtoSet = groupService.getPlayersFromGroup(1);

        PlayerDto player = playerDtoSet.stream()
                .filter(p -> p.getName().equals("dmz"))
                .findFirst()
                .orElseGet(PlayerDto::new);

        assertEquals("EventPreviewDto1 name does not match", player.getName(), "dmz");
    }

}
