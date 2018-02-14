package com.octopus.pb.repository;

import com.octopus.pb.model.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

    @Override
    Player save(Player player);

    @Override
    <S extends Player> List<S> save(Iterable<S> players);

    @Override
    void delete(Iterable<? extends Player> players);

    @Override
    void delete(Player player);

    @Override
    Player findOne(Integer id);

    @Override
    List<Player> findAll();

    @Query("SELECT MAX(id) FROM Player")
    Player findMax(Integer id);

}
