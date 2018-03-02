package com.octopus.pb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/page")
    public String getPage() {

        System.out.println("LOL INIT");

        return "page1.html";
    }

    @RequestMapping("/event")
    public String getEvent() {

        System.out.println("LOL INIT");

        return "events/events.html";
    }

    @RequestMapping("/team")
    public String getTeam() {

        System.out.println("LOL INIT");

        return "teams/teams.html";
    }

    @RequestMapping("/field")
    public String getField() {

        System.out.println("LOL INIT");

        return "fields/fields.html";
    }

    @RequestMapping("/player")
    public String getPlayer() {

        System.out.println("LOL INIT");

        return "players/players.html";
    }
}
