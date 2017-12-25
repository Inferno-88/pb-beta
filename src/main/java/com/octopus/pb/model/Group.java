package com.octopus.pb.model;


import com.octopus.pb.enums.GroupType;

import javax.persistence.*;

public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private GroupType groupType;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", foreignKey = @ForeignKey(name = "groups_to_events"))
    private Event event;

}
