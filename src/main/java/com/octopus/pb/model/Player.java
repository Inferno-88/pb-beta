package com.octopus.pb.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rank_id", foreignKey = @ForeignKey(name = "players_to_ranks"))
    private Rank rank;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", foreignKey = @ForeignKey(name = "players_to_teams"))
    private Team team;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "player_photos",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id")
    )
    private List<Photo> photoList;

}
