package com.octopus.pb.entity;


import com.octopus.pb.enums.Role;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;
    private String comment;
    private boolean isActive;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "users_to_players"))
    private Player player;

    public UserApp(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserApp(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void addPlayer(Player player) {
        setPlayer(player);
        player.setUser(this);
    }

    public void removePlayer(Player player) {
        setPlayer(null);
        player.setUser(null);
    }

}
