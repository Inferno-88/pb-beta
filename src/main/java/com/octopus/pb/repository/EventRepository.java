package com.octopus.pb.repository;

import com.octopus.pb.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    @Override
    Event save(Event event);

    @Override
    void delete(Event event);

    @Override
    Event findOne(Integer id);

    @Override
    List<Event> findAll();

}
