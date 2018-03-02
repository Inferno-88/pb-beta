package com.octopus.pb.service.impl;

import com.octopus.pb.enums.GroupType;
import com.octopus.pb.model.Event;
import com.octopus.pb.model.Field;
import com.octopus.pb.model.Group;
import com.octopus.pb.repository.EventRepository;
import com.octopus.pb.repository.FieldRepository;
import com.octopus.pb.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;


@Service("eventService")
@Slf4j
public class BaseEventService implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    FieldRepository fieldRepository;


    @PostConstruct
    private void init() {
        Event event = buildEvent();
        log.info("************** Preparing {} **************", BaseEventService.class);
        log.info("************** Created event with ID: {} **************", event.getId());
    }

    @Override
    public Event saveEvent(Event event) {
        return null;
    }

    @Override
    public Event getEvent(int id) {
        return eventRepository.findOne(id);
    }

    @Override
    public List<Event> getEventList() {
        return null;
    }


    //Custom methods
    private Event buildEvent() {

        Field field1 = Field.builder()
                .name("Field1")
                .fieldInfo("Info about field1")
                .address("City, Street, Building")
                .capacity(100)
                .build();

        Group redGroup = new Group(GroupType.RED);
        Group blueGroup = new Group(GroupType.RED);

        Event event1 = Event.builder()
                .name("Event1")
                .eventInfo("Info about event1")
                .beginDate(LocalDateTime.of(2018, Month.MAY, 20, 10, 0))
                .endDate(LocalDateTime.of(2018, Month.MAY, 20, 18, 0))
                .build();
        event1.addField(field1);
        event1.addGroup(redGroup);
        event1.addGroup(blueGroup);


        return eventRepository.save(event1);
    }

}
