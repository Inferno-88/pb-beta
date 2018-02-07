package com.octopus.pb.repository;

import com.octopus.pb.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

    @Override
    Team save(Team team);

    @Override
    <S extends Team> List<S> save(Iterable<S> teams);

    @Override
    void delete(Team team);

    @Override
    void delete(Iterable<? extends Team> entities);

    @Override
    Team findOne(Integer id);

    @Override
    List<Team> findAll();

}
