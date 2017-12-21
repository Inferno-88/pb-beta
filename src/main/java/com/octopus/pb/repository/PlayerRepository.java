package com.octopus.pb.repository;



import com.octopus.pb.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Override
    Player save(Player player);

    @Override
    Player findOne(Integer integer);

    @Override
    void delete(Player entity);

}
