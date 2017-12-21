package com.octopus.pb.model;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
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
    @JoinColumn(name = "rating_id")
    private Rating rating;

    @OneToMany(mappedBy = "field")
    private Set<Event> eventList = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "field_photos",
            joinColumns = @JoinColumn(name = "field_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id")
    )
    private List<Photo> photoList;

}
