package com.octopus.pb.controller;


import com.octopus.pb.enums.PhotoType;
import com.octopus.pb.model.Photo;
import com.octopus.pb.model.Player;
import com.octopus.pb.model.Rank;
import com.octopus.pb.model.Team;
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

        Rank rank = new Rank();
        rank.setName("First");

        Rank rank2 = new Rank();
        rank2.setName("TeamRank");

        Player player = new Player();
        player.setName("Player1");

        Team team = new Team();
        team.setName("lolz");
        team.setRank(rank2);

        player.setTeam(team);
        player.setRank(rank);

        Photo playerPhoto = new Photo();
        playerPhoto.setPhotoType(PhotoType.PLAYER);
        playerPhoto.setPath("Some player photo path");

        player.getPhotoList().add(playerPhoto);

        playerRepository.save(player);

    }

}
