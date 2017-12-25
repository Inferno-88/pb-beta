package com.octopus.pb.model;


import com.octopus.pb.enums.GroupType;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id", foreignKey = @ForeignKey(name = "events_to_fields"))
    private Field field;

    @OneToMany(mappedBy = "event")
    @MapKeyEnumerated(EnumType.STRING)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Map<GroupType, Group> groupSet = new HashMap<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_photos",
            joinColumns = @JoinColumn(name = "event_id", foreignKey = @ForeignKey(name = "event_photos_to_events")),
            inverseJoinColumns = @JoinColumn(name = "photo_id", foreignKey = @ForeignKey(name = "event_photos_to_photos")),
            uniqueConstraints = @UniqueConstraint(name = "event_photos_unique", columnNames = {"event_id", "photo_id"})
    )
    private List<Photo> photoList;

    public Event() {

    }

    public Event(String name) {
        this.name = name;
    }

}
