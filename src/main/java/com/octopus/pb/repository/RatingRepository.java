package com.octopus.pb.repository;


import com.octopus.pb.model.Rating;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer> {

    @Override
    Rating save(Rating rating);

    @Override
    void delete(Rating rating);

    @Override
    Rating findOne(Integer id);

    @Override
    List<Rating> findAll();

}
