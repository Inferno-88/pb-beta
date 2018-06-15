package com.octopus.pb.entity.security;


import com.octopus.pb.entity.Player;
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
@EqualsAndHashCode(exclude = {"roleAppSet"})
@Entity
@Table(name = "users")
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String comment;
    private boolean isActive;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "users_to_players"))
    private Player player;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_roles_to_users")),
            inverseJoinColumns = @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "user_roles_to_roles")),
            uniqueConstraints = @UniqueConstraint(name = "user_roles_unique", columnNames = {"user_id", "role_id"})
    )
    private final Set<RoleApp> roleAppSet = new HashSet<>();

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

    public void addRole(RoleApp roleApp) {
        roleAppSet.add(roleApp);
        roleApp.getUserAppSet().add(this);
    }

    public void removeRole(RoleApp roleApp) {
        roleApp.getUserAppSet().remove(this);
        roleAppSet.remove(roleApp);
    }

}
