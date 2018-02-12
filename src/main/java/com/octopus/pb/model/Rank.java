package com.octopus.pb.model;

import com.octopus.pb.enums.RankType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"playerSet", "teamSet"})
@Entity
@Table(name = "ranks")
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Enumerated(EnumType.STRING)
    private RankType rankType;

    @OneToMany(mappedBy = "rank")
    private Set<Player> playerSet = new HashSet<>();

    @OneToMany(mappedBy = "rank")
    private Set<Team> teamSet = new HashSet<>();

    public Rank() {

    }

    public Rank(String name, RankType rankType) {
        this.name = name;
        this.rankType = rankType;
    }

    public void addPlayer(Player player) {
        playerSet.add(player);
        player.setRank(this);
    }

    public void removePlayer(Player player) {
        player.setRank(null);
        playerSet.remove(player);
    }

    public void addTeam(Team team) {
        teamSet.add(team);
        team.setRank(this);
    }

    public void removeTeam(Team team) {
        team.setRank(null);
        teamSet.remove(team);
    }

}
