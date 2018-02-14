package com.octopus.pb.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"eventSet", "photoSet"})
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
    private Set<Event> eventSet = new HashSet<>();

    @ManyToMany(mappedBy = "fieldSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Photo> photoSet = new HashSet<>();

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
