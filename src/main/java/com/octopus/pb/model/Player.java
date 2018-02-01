package com.octopus.pb.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "groupSet, photoSet")
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

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "player_groups",
//            joinColumns = @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "player_groups_to_players")),
//            inverseJoinColumns = @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name = "player_groups_to_groups")),
//            uniqueConstraints = @UniqueConstraint(name = "player_groups_unique", columnNames = {"player_id", "group_id"})
//    )
    @ManyToMany(mappedBy = "playerSet")
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
