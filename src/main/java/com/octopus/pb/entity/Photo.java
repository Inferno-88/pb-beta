package com.octopus.pb.entity;

import com.octopus.pb.enums.PhotoType;
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
@EqualsAndHashCode(exclude = {"playerSet", "teamSet", "fieldSet", "eventSet"})
@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;

    @Enumerated(EnumType.STRING)
    private PhotoType photoType;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "player_photos",
            joinColumns = @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "player_photos_to_players")),
            inverseJoinColumns = @JoinColumn(name = "photo_id", foreignKey = @ForeignKey(name = "player_photos_to_photos")),
            uniqueConstraints = @UniqueConstraint(name = "player_photos_unique", columnNames = {"player_id", "photo_id"})
    )
    private final Set<Player> playerSet = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "team_photos",
            joinColumns = @JoinColumn(name = "team_id", foreignKey = @ForeignKey(name = "team_photos_to_teams")),
            inverseJoinColumns = @JoinColumn(name = "photo_id", foreignKey = @ForeignKey(name = "team_photos_to_photos")),
            uniqueConstraints = @UniqueConstraint(name = "team_photos_unique", columnNames = {"team_id", "photo_id"})
    )
    private final Set<Team> teamSet = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "field_photos",
            joinColumns = @JoinColumn(name = "field_id", foreignKey = @ForeignKey(name = "field_photos_to_fields")),
            inverseJoinColumns = @JoinColumn(name = "photo_id", foreignKey = @ForeignKey(name = "field_photos_to_photos")),
            uniqueConstraints = @UniqueConstraint(name = "field_photos_unique", columnNames = {"field_id", "photo_id"})
    )
    private final Set<Field> fieldSet = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "event_photos",
            joinColumns = @JoinColumn(name = "event_id", foreignKey = @ForeignKey(name = "event_photos_to_events")),
            inverseJoinColumns = @JoinColumn(name = "photo_id", foreignKey = @ForeignKey(name = "event_photos_to_photos")),
            uniqueConstraints = @UniqueConstraint(name = "event_photos_unique", columnNames = {"event_id", "photo_id"})
    )
    private final Set<Event> eventSet = new HashSet<>();

    public Photo(String path, PhotoType photoType) {
        this.path = path;
        this.photoType = photoType;
    }

    public void addPlayer(Player player) {
        playerSet.add(player);
        player.getPhotoSet().add(this);
    }

    public void removePlayer(Player player) {
        player.getPhotoSet().remove(this);
        playerSet.remove(player);
    }

    public void addTeam(Team team) {
        teamSet.add(team);
        team.getPhotoSet().add(this);
    }

    public void removeTeam(Team team) {
        team.getPhotoSet().remove(this);
        teamSet.remove(team);
    }

    public void addField(Field field) {
        fieldSet.add(field);
        field.getPhotoSet().add(this);
    }

    public void removeField(Field field) {
        field.getPhotoSet().remove(this);
        fieldSet.remove(field);
    }

    public void addEvent(Event event) {
        eventSet.add(event);
        event.getPhotoSet().add(this);
    }

    public void removeEvent(Event event) {
        event.getPhotoSet().remove(this);
        eventSet.remove(event);
    }

}
