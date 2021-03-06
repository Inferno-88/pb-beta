package com.octopus.pb.service;


import com.octopus.pb.dto.EventPreviewDto;
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

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Slf4j
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/db-wipe.sql")
public class EventServiceTest {

    @Autowired
    private BuildData buildData;

    @Autowired
    private EventService eventService;


    @Test
    public void testEventService() {

        Event event = buildData.buildEvent();
        EventPreviewDto eventPreviewDto1 = eventService.getEventPreviewDto(1);
        assertEquals("EventPreviewDto1 name does not match", eventPreviewDto1.getName(), "Some Event");
    }

}
