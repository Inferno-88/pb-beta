package com.octopus.pb.testdata;

import com.octopus.pb.entity.*;
import com.octopus.pb.enums.GroupType;
import com.octopus.pb.enums.RankType;
import com.octopus.pb.repository.EventRepository;
import com.octopus.pb.repository.GroupRepository;
import com.octopus.pb.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Month;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BuildData {

    private final EventRepository eventRepository;
    private final PlayerRepository playerRepository;
    private final GroupRepository groupRepository;


    public Event buildEvent() {

        Rating rating1 = new Rating();
        rating1.setPositive(10);
        rating1.setNegative(5);

        Rank rank1 = new Rank("Captain", RankType.PLAYER);
        Rank rank2 = new Rank("Regular", RankType.PLAYER);
        Rank rank3 = new Rank("9", RankType.TEAM);
        Rank rank4 = new Rank("11", RankType.TEAM);

        Field field1 = Field.builder()
                .name("Field1")
                .info("Info about field1")
                .address("City, Street, Building")
                .capacity(100)
                .rating(rating1)
                .build();

        Group redGroup = new Group(GroupType.RED);
        Group blueGroup = new Group(GroupType.BLUE);

        Player player1 = new Player("dmz");
        Player player2 = new Player("mu8d");

        player1.setRankAddPlayer(rank1);
        player2.setRankAddPlayer(rank2);

        player1 = playerRepository.save(player1);
        player2 = playerRepository.save(player2);

        Team team1 = new Team("Irish");
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.setRankAddTeam(rank3);
        team1.setRankAddTeam(rank4);

        redGroup.addPlayer(player1);
        blueGroup.addPlayer(player2);

        redGroup = groupRepository.save(redGroup);
        blueGroup = groupRepository.save(blueGroup);

        Event event1 = Event.builder()
                .name("Some Event")
                .info("Info about event")
                .capacity(888)
                .beginDate(LocalDateTime.of(2018, Month.MAY, 20, 10, 0))
                .endDate(LocalDateTime.of(2018, Month.MAY, 20, 18, 0))
                .build();
        event1.addField(field1);
        event1.addGroup(redGroup);
        event1.addGroup(blueGroup);

        return eventRepository.save(event1);
    }

}
