package com.octopus.pb.controller;

import com.octopus.pb.dto.EventDto;
import com.octopus.pb.dto.EventPreviewDto;
import com.octopus.pb.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/event")
@Slf4j
public class EventController {

    @Autowired
    private EventService eventService;


    @GetMapping("/previews/{id}")
    public EventPreviewDto getEventPreviewList(@PathVariable("id") int id) {
        return eventService.getEventPreviewDto(id);
    }

    @GetMapping("/previews")
    public List<EventPreviewDto> getEventPreviewList() {
        return eventService.getEventPreviewDtoList();
    }

    @GetMapping("/events/{id}")
    public EventDto getEvent(@PathVariable("id") int id) {
        return eventService.getEventDto(id);
    }

    @GetMapping("/events")
    public List<EventDto> getEventList() {
        return eventService.getEventDtoList();
    }

    @PostMapping("/events")
    public EventDto createEvent(EventDto eventDto) {
        return eventService.createEventDto(eventDto);
    }
    
}
