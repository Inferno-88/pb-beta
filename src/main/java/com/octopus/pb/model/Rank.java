package com.octopus.pb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ranks")
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(mappedBy = "rank")
    private Player player;

    @OneToOne(mappedBy = "rank")
    private Team team;

}
