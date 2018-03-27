package com.octopus.pb.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"playerSet", "photoSet"})
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String shortName;
    private String teamInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rank_id", foreignKey = @ForeignKey(name = "teams_to_ranks"))
    private Rank rank;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private final Set<Player> playerSet = new HashSet<>();

    @ManyToMany(mappedBy = "teamSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private final Set<Photo> photoSet = new HashSet<>();

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
        setRank(rank);
        rank.addTeam(this);
    }

    public void unsetRankRemovePlayer() {
        this.rank.getTeamSet().remove(this);
        setRank(null);
    }

}
