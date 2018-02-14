package com.octopus.pb.repository;

import com.octopus.pb.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    User save(User user);

    @Override
    <S extends User> List<S> save(Iterable<S> users);

    @Override
    void delete(Iterable<? extends User> users);

    @Override
    void delete(User user);

    @Override
    User findOne(Integer id);

    @Override
    List<User> findAll();

}
