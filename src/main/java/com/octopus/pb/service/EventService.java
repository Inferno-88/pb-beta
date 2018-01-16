package com.octopus.pb.service;


import com.octopus.pb.model.Event;

import java.util.List;

public interface EventService {

    String createEvent();

    List<Event> getEventList();



}
