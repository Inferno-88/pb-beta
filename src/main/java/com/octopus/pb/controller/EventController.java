package com.octopus.pb.controller;

import com.octopus.pb.dto.EventDto;
import com.octopus.pb.dto.EventPreviewDto;
import com.octopus.pb.dto.GroupDto;
import com.octopus.pb.dto.PlayerDto;
import com.octopus.pb.entity.Event;
import com.octopus.pb.service.EventService;
import com.octopus.pb.service.GroupService;
import com.octopus.pb.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/event")
@Slf4j
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private GroupService groupService;



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

    //Main Controller methods


}
