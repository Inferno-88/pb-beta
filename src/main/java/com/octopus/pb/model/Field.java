package com.octopus.pb.model;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "fields")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private int capacity;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rating_id", foreignKey = @ForeignKey(name = "fields_to_ratings"))
    private Rating rating;

    @OneToMany(mappedBy = "field")
    private Set<Event> eventList = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "field_photos",
            joinColumns = @JoinColumn(name = "field_id", foreignKey = @ForeignKey(name = "field_photos_to_fields")),
            inverseJoinColumns = @JoinColumn(name = "photo_id", foreignKey = @ForeignKey(name = "field_photos_to_photos")),
            uniqueConstraints = @UniqueConstraint(name = "field_photos_unique", columnNames = {"field_id", "photo_id"})
    )
    private Set<Photo> photoSet = new HashSet<>();

    public Field() {

    }

    public Field(String name) {
        this.name = name;
    }

}
