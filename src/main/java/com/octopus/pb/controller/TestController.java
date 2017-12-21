package com.octopus.pb.controller;


import com.octopus.pb.model.Player;
import com.octopus.pb.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    PlayerRepository playerRepository;


    @GetMapping("/test")
    private void test() {

        Player player = new Player();
        player.setName("lol");

        playerRepository.save(player);
    }

}
