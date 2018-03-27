package com.octopus.pb.mapper;


import com.octopus.pb.dto.EventDto;
import com.octopus.pb.dto.EventPreviewDto;
import com.octopus.pb.entity.Event;
import com.octopus.pb.entity.Field;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Slf4j
public class EventMapperTest {

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private EventPreviewMapper eventPreviewMapper;

    @Autowired
    private CycleAvoidContext cycleAvoidContext;


    @Test
    public void givenEventEntityToEventDto_whenMaps_thenCorrect() {
        Event eventEntity = new Event();
        eventEntity.setName("BPM");

        EventDto eventDto = eventMapper.entityToDto(eventEntity, cycleAvoidContext);

        assertEquals("EventEntity name does not match EventDto name", eventEntity.getName(), eventDto.getName());
    }

    @Test
    public void givenEventDtoToEventEntity_whenMaps_thenCorrect() {
        EventDto eventDto = new EventDto();
        eventDto.setName("BattleShip");

        Event eventEntity = eventMapper.dtoToEntity(eventDto, cycleAvoidContext);

        assertEquals("EventDto name does not match EventEntity name", eventDto.getName(), eventEntity.getName());
    }

    @Test
    public void givenEventEntityToEventPreviewDto_whenMaps_thenCorrect() {
        Event eventEntity = Event.builder()
                .id(1)
                .name("EventMapperTest name")
                .beginDate(LocalDateTime.of(2018, 8, 8, 0, 0))
                .capacity(88)
                .shortInfo("EventMapperTest shortInfo")
                .field(new Field("EventMapperTest fieldName"))
                .build();

        EventPreviewDto eventPreviewDto = eventPreviewMapper.entityToDto(eventEntity);

        assertEquals("EventPreviewDto name does not match EventEntity", eventEntity.getName(), eventPreviewDto.getName());
        assertEquals("EventPreviewDto shortInfo does not match EventEntity", eventEntity.getShortInfo(), eventPreviewDto.getShortInfo());
        assertEquals("EventPreviewDto fieldName does not match EventEntity", eventEntity.getField().getName(), eventPreviewDto.getFieldName());
    }

}
