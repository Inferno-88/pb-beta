package com.octopus.pb.service.impl;

import com.octopus.pb.model.Event;
import com.octopus.pb.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("eventService")
public class BaseEventService implements EventService {

    @Override
    public Event saveEvent(Event event) {
        return null;
    }

    @Override
    public Event getEvent(Event event) {
        return null;
    }

    @Override
    public List<Event> getEventList() {
        return null;
    }

}
