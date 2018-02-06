package com.octopus.pb.controller;

import com.octopus.pb.model.Event;
import com.octopus.pb.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;


    @PostMapping("/create")
    public @ResponseBody String createEvent(@RequestParam String json) {
        String response = "Created event: ??";

        //TODO needs logic

        return response;
    }

    @GetMapping("/getAll")
    public @ResponseBody List<Event> getEventList() {

        List<Event> eventList = new ArrayList<>();

        //TODO something

        return eventList;
    }

}
