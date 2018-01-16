package com.octopus.pb.controller;

import com.octopus.pb.model.Event;
import com.octopus.pb.service.EventService;
import com.octopus.pb.service.AssemblerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {


    @Autowired
    EventService eventService;

    @Autowired
    AssemblerService assemblerService;


    @GetMapping("/events/getAll")
    public List<Event> getEventList() {

        List<Event> eventList = new ArrayList<>();

        //TODO something

        eventList = eventService.getEventList();

        return eventList;
    }

    @PostMapping("/event/create")
    public String createEvent(@RequestParam String json) {
        String response = "Created event: ";

        //TODO create event logic
        eventService.createEvent();

        return response;
    }

}
