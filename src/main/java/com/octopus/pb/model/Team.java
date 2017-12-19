package com.octopus.pb.model;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;

    @OneToOne
    @JoinColumn(name = "rank_id")
    private Rank rank;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Player> playerList = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "team_photos",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Photo> photoList;

    //Utility methods
    private void addPlayer(Player player) {
        playerList.add(player);
        player.setTeam(this);
    }

    private void removePlayer(Player player) {
        playerList.remove(player);
        player.setTeam(null);
    }

}
