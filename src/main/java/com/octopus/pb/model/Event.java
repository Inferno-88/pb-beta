package com.octopus.pb.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.octopus.pb.enums.GroupType;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"groupMap", "photoSet"})
@AllArgsConstructor
@Entity
@Table(name = "events")
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String eventInfo;
    private String gameRules;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id", foreignKey = @ForeignKey(name = "events_to_fields"))
    private Field field;

    @JsonIgnore
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @MapKey(name="groupType")
    @MapKeyEnumerated(EnumType.STRING)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Map<GroupType, Group> groupMap = new HashMap<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "eventSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private final Set<Photo> photoSet = new HashSet<>();

    public Event() {
    }

    public Event(String name) {
        this.name = name;
    }

    public Event(String name, LocalDateTime beginDate, LocalDateTime endDate, boolean isActive) {
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    public void addGroup(Group group) {
        groupMap.put(group.getGroupType(), group);
        group.setEvent(this);
    }

    public void addGroupList(List<Group> groupList) {
        groupList.forEach(g -> {
            groupMap.put(g.getGroupType(), g);
            g.setEvent(this);
        });
    }

    public void removeGroup(Group group) {
        group.setEvent(null);
        groupMap.remove(group.getGroupType());
    }

    public void addField(Field field) {
        setField(field);
        field.getEventSet().add(this);
    }

    public void removeField(Field field) {
        setField(null);
        field.getEventSet().remove(this);
    }

}
