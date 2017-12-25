package com.octopus.pb.repository;

import com.octopus.pb.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    @Override
    Event save(Event event);

    @Override
    void delete(Event event);

    @Override
    Event findOne(Long id);

    @Override
    List<Event> findAll();

}
