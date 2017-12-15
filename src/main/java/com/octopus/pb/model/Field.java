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
    private List<BufferedImage> imageList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Rating rating;

    @OneToOne(mappedBy = "field")
    private Event event;
    
}
