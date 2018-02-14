package com.octopus.pb.repository;

import com.octopus.pb.model.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {

    @Override
    Photo save(Photo photo);

    @Override
    <S extends Photo> List<S> save(Iterable<S> photos);

    @Override
    void delete(Iterable<? extends Photo> photos);

    @Override
    void delete(Photo photo);

    @Override
    Photo findOne(Integer id);

    @Override
    List<Photo> findAll();

}
