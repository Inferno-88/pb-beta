package com.octopus.pb.model;

import lombok.Data;

import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.util.List;

@Data
@Entity
@Table(name = "fields")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private String address;
    private int capacity;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "field")
    private Rating rating;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "field")
    private List<Event> eventList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "field_photos",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Photo> photoList;

}
