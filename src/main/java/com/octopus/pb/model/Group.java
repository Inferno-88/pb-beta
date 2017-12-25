package com.octopus.pb.model;


import com.octopus.pb.enums.GroupType;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private GroupType groupType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", foreignKey = @ForeignKey(name = "groups_to_events"))
    private Event event;

    public Group(GroupType groupType, Event event) {
        this.groupType = groupType;
        this.event = event;
    }

}
