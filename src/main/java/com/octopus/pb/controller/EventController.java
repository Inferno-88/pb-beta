package com.octopus.pb.controller;

import com.octopus.pb.dto.EventDto;
import com.octopus.pb.dto.EventPreviewDto;
import com.octopus.pb.entity.Event;
import com.octopus.pb.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/event")
@Slf4j
public class EventController {

    @Autowired
    private EventService eventService;


    @GetMapping("/getPreview/{id}")
    public EventPreviewDto getEventPreviewList(@PathVariable("id") int id) {
        return eventService.getEventPreviewDto(id);
    }

    @GetMapping("/getPreviewList")
    public List<EventPreviewDto> getEventPreviewList() {
        return eventService.getEventPreviewDtoList();
    }

    @GetMapping("/get/{id}")
    public Event getEvent(@PathVariable("id") int id) {
        return eventService.getEvent(id);
    }

    @GetMapping("/getAll")
    public List<EventDto> getEventList() {
        return eventService.getEventDtoList();
    }

    @GetMapping("/getAll2")
    public List<Event> getEventList2() {
        return eventService.getEventList();
    }

}
