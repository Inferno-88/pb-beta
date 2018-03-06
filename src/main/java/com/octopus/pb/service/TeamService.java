package com.octopus.pb.service;

import com.octopus.pb.entity.Team;

import java.util.List;


public interface TeamService {

    //Core methods


    //Repository methods
    Team saveTeam(Team player);

    Team getTeam(Team player);

    void deleteTeam(Team player);

    List<Team> getTeamList();

}
