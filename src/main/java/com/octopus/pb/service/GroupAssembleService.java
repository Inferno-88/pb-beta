package com.octopus.pb.service;


import com.octopus.pb.model.Group;

import java.util.List;


public interface GroupAssembleService {

    Group saveGroup(Group group);

    void deleteGroup(Group group);

    Group getGroup(Long id);

    List<Group> findAll();

}
