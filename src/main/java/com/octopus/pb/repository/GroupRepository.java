package com.octopus.pb.repository;


import com.octopus.pb.entity.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

    @Override
    Group save(Group group);

    @Override
    <S extends Group> Iterable<S> save(Iterable<S> groups);

    @Override
    void delete(Group group);

    @Override
    Group findOne(Integer id);

    @Override
    List<Group> findAll();

}
