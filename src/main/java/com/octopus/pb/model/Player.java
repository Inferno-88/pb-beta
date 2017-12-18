package com.octopus.pb.model;

import com.octopus.pb.enums.PhotoType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "player")
    private Rank rank;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "player_photos",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Photo> photoList;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
