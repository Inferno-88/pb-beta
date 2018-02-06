package com.octopus.pb.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"groupSet", "photoSet", "user"})
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

    @OneToOne(mappedBy = "player")
    private User user;

    @ManyToMany(mappedBy = "playerSet", cascade = CascadeType.ALL)
    private Set<Group> groupSet = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "player_photos",
            joinColumns = @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "player_photos_to_players")),
            inverseJoinColumns = @JoinColumn(name = "photo_id", foreignKey = @ForeignKey(name = "player_photos_to_photos")),
            uniqueConstraints = @UniqueConstraint(name = "player_photos_unique", columnNames = {"player_id", "photo_id"})
    )
    private Set<Photo> photoSet = new HashSet<>();

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public void addGroup(Group group) {
        groupSet.add(group);
        group.getPlayerSet().add(this);
    }

    public void removeGroup(Group group) {
        group.getPlayerSet().remove(this);
        groupSet.remove(group);
    }

}
