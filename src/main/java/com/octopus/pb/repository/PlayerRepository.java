package com.octopus.pb.repository;

import com.octopus.pb.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    @Override
    Player save(Player player);

    @Override
    void delete(Player entity);

    @Override
    Player findOne(Long id);

    @Override
    List<Player> findAll();

}