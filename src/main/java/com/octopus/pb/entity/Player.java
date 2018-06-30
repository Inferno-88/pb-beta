package com.octopus.pb.entity;

import com.octopus.pb.entity.security.UserApp;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"user", "groupSet", "photoSet"})
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

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    private UserApp user;

    @ManyToMany(mappedBy = "playerSet")
    private final Set<Group> groupSet = new HashSet<>();

    @ManyToMany(mappedBy = "playerSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private final Set<Photo> photoSet = new HashSet<>();

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

    public void setRankAddPlayer(Rank rank) {
        setRank(rank);
        rank.addPlayer(this);
    }

    public void unsetRankRemovePlayer() {
        this.rank.getPlayerSet().remove(this);
        setRank(null);
    }

    public void addPhoto(Photo photo) {
        photoSet.add(photo);
        photo.getPlayerSet().add(this);
    }

    public void removePhoto(Photo photo) {
        photo.getPlayerSet().remove(this);
        photoSet.remove(photo);
    }

}
