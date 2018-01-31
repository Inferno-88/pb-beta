package com.octopus.pb.repository;


import com.octopus.pb.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

    @Override
    Group save(Group group);

    @Override
    <S extends Group> Iterable<S> save(Iterable<S> entities);

    @Override
    void delete(Group group);

    @Override
    Group findOne(Long id);

    @Override
    List<Group> findAll();

}
