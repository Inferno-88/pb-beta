package com.octopus.pb.repository;



import com.octopus.pb.entity.Field;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FieldRepository extends CrudRepository<Field, Integer> {

    @Override
    Field save(Field field);

    @Override
    <S extends Field> List<S> save(Iterable<S> fields);

    @Override
    void delete(Field field);

    @Override
    void delete(Iterable<? extends Field> fields);

    @Override
    Field findOne(Integer id);

    @Override
    List<Field> findAll();

}
