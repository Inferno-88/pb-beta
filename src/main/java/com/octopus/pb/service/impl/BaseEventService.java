package com.octopus.pb.service.impl;

import com.octopus.pb.model.Event;
import com.octopus.pb.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("eventService")
public class BaseEventService implements EventService {

    @Override
    public String createEvent() {
        return null;
    }

    @Override
    public List<Event> getEventList() {
        return null;
    }

}
