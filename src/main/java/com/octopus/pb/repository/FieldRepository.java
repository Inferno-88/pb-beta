package com.octopus.pb.repository;



import com.octopus.pb.model.Field;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FieldRepository extends CrudRepository<Field, Integer> {

    @Override
    Field save(Field entity);

    @Override
    <S extends Field> List<S> save(Iterable<S> entities);

    @Override
    void delete(Field entity);

    @Override
    void delete(Iterable<? extends Field> entities);

    @Override
    Field findOne(Integer id);

    @Override
    List<Field> findAll();

}
