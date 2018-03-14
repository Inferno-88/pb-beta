package com.octopus.pb.mapper;


import com.octopus.pb.dto.EventDto;
import com.octopus.pb.entity.Event;
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
public class EventMapperTest {

    @Autowired
    private EventMapper eventMapper;

    @Test
    public void givenEventEntityToEventDto_whenMaps_thenCorrect() {
        Event eventEntity = new Event();
        eventEntity.setName("BPM");

        EventDto eventDto = eventMapper.entityToDto(eventEntity);

        assertEquals("EventEntity name does not match EventDto name", eventEntity.getName(), eventDto.getName());
    }

    @Test
    public void givenEventDtoToEventEntity_whenMaps_thenCorrect() {
        EventDto eventDto = new EventDto();
        eventDto.setName("BattleShip");

        Event eventEntity = eventMapper.dtoToEntity(eventDto);

        assertEquals("EventDto name does not match EventEntity name", eventDto.getName(), eventEntity.getName());
    }

}
