package com.octopus.pb.repository;

import com.octopus.pb.model.Rank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RankRepository extends CrudRepository<Rank, Long> {

    @Override
    Rank save(Rank rank);

    @Override
    void delete(Rank rank);

    @Override
    Rank findOne(Long id);

    @Override
    List<Rank> findAll();

}
