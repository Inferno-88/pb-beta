package com.octopus.pb.service;


import com.octopus.pb.dto.EventDto;
import com.octopus.pb.dto.EventPreviewDto;
import com.octopus.pb.entity.Event;
import java.util.List;

public interface EventService {

    //DTO methods
    EventPreviewDto getEventPreviewDto(int id);

    List<EventPreviewDto> getEventPreviewDtoList();

    EventDto getEventDto(int id);

    List<EventDto> getEventDtoList();

    //Repository methods
    Event saveEvent(Event event);

    void delete(Event event);

    Event getEvent(int id);

    List<Event> getEventList();

}
