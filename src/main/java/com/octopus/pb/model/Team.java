package com.octopus.pb.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"playerSet", "photoSet"})
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rank_id", foreignKey = @ForeignKey(name = "teams_to_ranks"))
    private Rank rank;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Player> playerSet = new HashSet<>();

    @ManyToMany(mappedBy = "teamSet")
    private Set<Photo> photoSet = new HashSet<>();

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        playerSet.add(player);
        player.setTeam(this);
    }

    public void removePlayer(Player player) {
        player.setTeam(null);
        playerSet.remove(player);
    }

    public void setRankAddTeam(Rank rank) {
        rank.addTeam(this);
    }

}
