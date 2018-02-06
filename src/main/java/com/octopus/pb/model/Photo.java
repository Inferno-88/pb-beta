package com.octopus.pb.model;

import com.octopus.pb.enums.PhotoType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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
            joinColumns = @JoinColumn(name = "field_id", foreignKey = @ForeignKey(name = "field_photos_to_fields")),
            inverseJoinColumns = @JoinColumn(name = "photo_id", foreignKey = @ForeignKey(name = "field_photos_to_photos")),
            uniqueConstraints = @UniqueConstraint(name = "field_photos_unique", columnNames = {"field_id", "photo_id"})
    )
    private Set<Player> playerSet = new HashSet<>();

    public Photo(String path, PhotoType photoType) {
        this.path = path;
        this.photoType = photoType;
    }
    
}
