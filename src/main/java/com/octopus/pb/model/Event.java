package com.octopus.pb.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id", foreignKey = @ForeignKey(name = "events_to_fields"))
    private Field field;

    @OneToMany


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_photos",
            joinColumns = @JoinColumn(name = "event_id", foreignKey = @ForeignKey(name = "event_photos_to_events")),
            inverseJoinColumns = @JoinColumn(name = "photo_id", foreignKey = @ForeignKey(name = "event_photos_to_photos")),
            uniqueConstraints = @UniqueConstraint(name = "event_photos_unique", columnNames = {"event_id", "photo_id"})
    )
    private List<Photo> photoList;

}
