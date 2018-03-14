package com.octopus.pb.service;


import com.octopus.pb.dto.EventPreviewDto;
import com.octopus.pb.entity.Event;
import java.util.List;

public interface EventService {

    //Core methods
    Event buildEvent();

    //DTO methods
    EventPreviewDto getEventPreview(int id);

    List<EventPreviewDto> getEventPreviewList();

    //Repository methods
    Event saveEvent(Event event);

    Event getEvent(int id);

    List<Event> getEventList();

}
