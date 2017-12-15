package com.octopus.pb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ranks")
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;

    @OneToOne(mappedBy = "rank")
    private Player player;

}
