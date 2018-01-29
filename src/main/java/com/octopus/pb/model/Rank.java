package com.octopus.pb.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "playerSet, teamSet")
@Entity
@Table(name = "ranks")
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Enumerated(EnumType.STRING)
    private String rankType;

    @OneToMany(mappedBy = "rank")
    private Set<Player> playerSet = new HashSet<>();

    @OneToMany(mappedBy = "rank")
    private Set<Team> teamSet = new HashSet<>();

    public Rank(String name, String rankType) {
        this.name = name;
        this.rankType = rankType;
    }

}
