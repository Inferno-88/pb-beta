package com.octopus.pb.service;


import com.octopus.pb.model.Event;
import java.util.List;

public interface EventService {

    //Core methods


    //Repository methods
    Event saveEvent(Event event);

    Event getEvent(Event event);

    List<Event> getEventList();

}
