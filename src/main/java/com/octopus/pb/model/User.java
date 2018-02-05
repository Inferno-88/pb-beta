package com.octopus.pb.model;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    private String email;
    private String comment;
    private boolean isActive;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "users_to_players"))
    private Player player;

    public User(String login, String password, String email, Player player) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.player = player;
    }

}
