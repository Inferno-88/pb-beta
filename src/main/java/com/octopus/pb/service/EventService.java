package com.octopus.pb.service;


import com.octopus.pb.entity.Event;
import java.util.List;

public interface EventService {

    //Core methods
    Event buildEvent();


    //Repository methods
    Event saveEvent(Event event);

    Event getEvent(int id);

    List<Event> getEventList();

}
