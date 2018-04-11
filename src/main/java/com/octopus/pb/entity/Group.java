package com.octopus.pb.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.octopus.pb.enums.GroupType;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "playerSet")
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private GroupType groupType;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", foreignKey = @ForeignKey(name = "groups_to_events"))
    private Event event;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "player_groups",
            joinColumns = @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name = "player_groups_to_groups")),
            inverseJoinColumns = @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "player_groups_to_players")),
            uniqueConstraints = @UniqueConstraint(name = "player_groups_unique", columnNames = {"group_id", "player_id"})
    )
    private final Set<Player> playerSet = new HashSet<>();

    public Group(GroupType groupType) {
        this.groupType = groupType;
    }

    public void addPlayer(Player player) {
        playerSet.add(player);
        player.getGroupSet().add(this);
    }

    public void addPlayerList(List<Player> playerList) {
        playerList.forEach(p -> {
            playerSet.add(p);
            p.getGroupSet().add(this);
        });
    }

    public void removePlayer(Player player) {
        player.getGroupSet().remove(this);
        playerSet.remove(player);
    }

}
