package com.octopus.pb.service;


import com.octopus.pb.model.Event;
import java.util.List;

public interface EventService {

    Event saveEvent(Event event);

    Event getEvent(Event event);

    List<Event> getEventList();

}
