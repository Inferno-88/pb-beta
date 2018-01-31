package com.octopus.pb.repository;

import com.octopus.pb.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    @Override
    Team save(Team team);

    @Override
    <S extends Team> Iterable<S> save(Iterable<S> teams);

    @Override
    void delete(Team team);

    @Override
    Team findOne(Long id);

    @Override
    List<Team> findAll();

}
