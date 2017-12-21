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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rank_id", foreignKey = @ForeignKey(name = "teams_to_ranks"))
    private Rank rank;

    @OneToMany(mappedBy = "team")
    private Set<Player> playerSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "team_photos",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id")
    )
    private List<Photo> photoList;

}
