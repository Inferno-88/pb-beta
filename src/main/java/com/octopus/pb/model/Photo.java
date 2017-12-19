package com.octopus.pb.model;

import com.octopus.pb.enums.PhotoType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;

    @Enumerated(EnumType.STRING)
    private PhotoType photoType;

}
