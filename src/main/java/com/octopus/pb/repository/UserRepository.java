package com.octopus.pb.repository;

import com.octopus.pb.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    User save(User users);

    @Override
    <S extends User> List<S> save(Iterable<S> users);

    @Override
    void delete(Iterable<? extends User> entities);

    @Override
    void delete(User entity);

    @Override
    User findOne(Integer id);

    @Override
    List<User> findAll();

}
