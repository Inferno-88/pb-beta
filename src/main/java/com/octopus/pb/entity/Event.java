package com.octopus.pb.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.octopus.pb.enums.GroupType;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"groupMap", "photoSet"})
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(length = 10485760)
    private String info;

    @Column(length = 10485760)
    private String shortInfo;

    @Column(length = 10485760)
    private String gameRules;

    private int capacity;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id", foreignKey = @ForeignKey(name = "events_to_fields"))
    private Field field;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @MapKey(name="groupType")
    @MapKeyEnumerated(EnumType.STRING)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Map<GroupType, Group> groupMap = new HashMap<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "eventSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private final Set<Photo> photoSet = new HashSet<>();

    public Event(String name) {
        this.name = name;
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

    public void addPhoto(Photo photo) {
        photoSet.add(photo);
        photo.getEventSet().add(this);
    }

    public void removePhoto(Photo photo) {
        photo.getPlayerSet().remove(this);
        photoSet.remove(photo);
    }

}