package com.octopus.pb.controller;


import com.octopus.pb.entity.Player;
import com.octopus.pb.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupService groupService;


    @PostMapping("/addplayer")
    public String addPlayer(@RequestParam String json) {
        String response = "Added player: ??";

        //TODO needs logic

        return response;
    }

    @GetMapping("/getplayers")
    public List<Player> getPlayerList(@RequestParam String json) {

        List<Player> playerList = new ArrayList<>();

        //TODO something

        return playerList;
    }

}

