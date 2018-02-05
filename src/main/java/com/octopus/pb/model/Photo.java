package com.octopus.pb.model;

import com.octopus.pb.enums.PhotoType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    public Photo(String path, PhotoType photoType) {
        this.path = path;
        this.photoType = photoType;
    }

}
