package com.octopus.pb.repository;

import com.octopus.pb.entity.UserApp;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserApp, Integer> {

    @Override
    UserApp save(UserApp user);

    @Override
    <S extends UserApp> List<S> save(Iterable<S> users);

    @Override
    void delete(Iterable<? extends UserApp> users);

    @Override
    void delete(UserApp user);

    @Override
    UserApp findOne(Integer id);

    @Override
    List<UserApp> findAll();

    UserApp findByUsername(String username);

}
