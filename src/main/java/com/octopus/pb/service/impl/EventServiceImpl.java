package com.octopus.pb.service.impl;

import com.octopus.pb.dto.EventDto;
import com.octopus.pb.dto.EventPreviewDto;
import com.octopus.pb.entity.*;
import com.octopus.pb.enums.GroupType;
import com.octopus.pb.manager.Mediator;
import com.octopus.pb.mapper.CycleAvoidContext;
import com.octopus.pb.mapper.EventMapper;
import com.octopus.pb.mapper.EventPreviewMapper;
import com.octopus.pb.repository.EventRepository;
import com.octopus.pb.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;


@Service("eventService")
@Slf4j
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final Mediator mediator;
    private final EventMapper eventMapper;
    private final EventPreviewMapper eventPreviewMapper;
    private final EventRepository eventRepository;
    private final CycleAvoidContext cycleAvoidContext;


    @PostConstruct
    private void init() {
        log.info("************** Preparing {} **************", EventService.class);
    }


    public EventPreviewDto getEventPreviewDto(int id) {
        return eventPreviewMapper.entityToDto(getEvent(id));
    }

    public List<EventPreviewDto> getEventPreviewDtoList() {
        return getEventList().stream()
                .map(e -> eventPreviewMapper.entityToDto(e))
                .collect(Collectors.toList());
    }

    public List<EventDto> getEventDtoList() {
        return getEventList().stream()
                .map(e -> eventMapper.entityToDto(e, cycleAvoidContext))
                .collect(Collectors.toList());
    }

    //Custom methods
    public Event buildEvent() {

        Rating rating1 = new Rating();
        rating1.setPositive(10);
        rating1.setNegative(5);

        Field field1 = Field.builder()
                .name("Field1")
                .info("Info about field1")
                .address("City, Street, Building")
                .capacity(100)
                .rating(rating1)
                .build();

        Group redGroup = new Group(GroupType.RED);
        Group blueGroup = new Group(GroupType.BLUE);

        Player player1 = new Player("dmz");
        Player player2 = new Player("mu8d");

        redGroup.addPlayer(player1);
        blueGroup.addPlayer(player2);

        Event event1 = Event.builder()
                .name("Some Event")
                .info("Info about event")
                .capacity(888)
                .beginDate(LocalDateTime.of(2018, Month.MAY, 20, 10, 0))
                .endDate(LocalDateTime.of(2018, Month.MAY, 20, 18, 0))
                .build();
        event1.addField(field1);
        event1.addGroup(redGroup);
        event1.addGroup(blueGroup);

        return saveEvent(event1);
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event getEvent(int id) {
        return eventRepository.findOne(id);
    }

    @Override
    public List<Event> getEventList() {
        return eventRepository.findAll();
    }

}
