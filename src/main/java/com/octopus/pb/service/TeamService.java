package com.octopus.pb.service;

import com.octopus.pb.model.Team;

import java.util.List;


public interface TeamService {

    Team saveTeam(Team player);

    Team getTeam(Team player);

    void deleteTeam(Team player);

    List<Team> getTeamList();

}
