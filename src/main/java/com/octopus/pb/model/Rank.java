package com.octopus.pb.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "ranks")
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "rank")
    private Set<Player> playerSet = new HashSet<>();

    @OneToMany(mappedBy = "rank")
    private Set<Team> teamSet = new HashSet<>();

}
