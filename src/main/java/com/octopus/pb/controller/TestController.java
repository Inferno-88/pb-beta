package com.octopus.pb.controller;


import com.octopus.pb.data.InitDataBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    InitDataBuilder initDataBuilder;

    @RequestMapping("/page")
    public String getPage() {
        return "page1.html";
    }

    @RequestMapping("/event")
    public String getEvent() {
        return "events/events.html";
    }

    @RequestMapping("/team")
    public String getTeam() {
        return "teams/teams.html";
    }

    @RequestMapping("/field")
    public String getField() {
        return "fields/fields.html";
    }

    @RequestMapping("/player")
    public String getPlayer() {
        return "players/players.html";
    }

    @RequestMapping("/build")
    public @ResponseBody String buildData() {
        initDataBuilder.buildData();

        return "Built";
    }

}
