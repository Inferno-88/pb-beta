package com.octopus.pb.model;


import com.octopus.pb.enums.GroupType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static sun.audio.AudioPlayer.player;

@Data
@EqualsAndHashCode(exclude = "playerSet")
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private GroupType groupType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", foreignKey = @ForeignKey(name = "groups_to_events"))
    private Event event;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "player_groups",
            joinColumns = @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name = "player_groups_to_groups")),
            inverseJoinColumns = @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "player_groups_to_players")),
            uniqueConstraints = @UniqueConstraint(name = "player_groups_unique", columnNames = {"player_id", "group_id"})
    )
    private Set<Player> playerSet = new HashSet<>();

    public Group(GroupType groupType, Event event) {
        this.groupType = groupType;
        this.event = event;
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
