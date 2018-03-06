package com.octopus.pb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"eventSet", "photoSet"})
@AllArgsConstructor
@Entity
@Table(name = "fields")
@Builder
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String fieldInfo; //TODO fieldDetails object with fieldInfo, capacity, size, type, etc.
    private String address;
    private int capacity;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rating_id", foreignKey = @ForeignKey(name = "fields_to_ratings"))
    private Rating rating;

    @JsonIgnore
    @OneToMany(mappedBy = "field")
    private final Set<Event> eventSet = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "fieldSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private final Set<Photo> photoSet = new HashSet<>();

    public Field() {

    }

    public Field(String name) {
        this.name = name;
    }

    public Field(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public void addRating(Rating rating) {
        setRating(rating);
        rating.setField(this);
    }

    public void removeRating(Rating rating) {
        setRating(null);
        rating.setField(null);
    }

}
