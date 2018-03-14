package com.octopus.pb.service;


import com.octopus.pb.dto.EventPreviewDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Slf4j
public class EventServiceTest {

    @Autowired
    private EventService eventService;


    @Test
    public void testEventService() {
        eventService.buildEvent();
//
//        EventPreviewDto eventPreviewDto1 = eventService.getEventPreview(3);
//        assertEquals("EventPreviewDto1 name does not match", eventPreviewDto1.getName(), "Event3");
    }

}
