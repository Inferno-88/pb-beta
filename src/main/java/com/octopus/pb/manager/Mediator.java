package com.octopus.pb.manager;

import org.springframework.data.repository.CrudRepository;

public interface Mediator {

    <T extends CrudRepository, R> T getRepo(String repoName);

//    <T extends CrudRepository, R> T getRepository(Class<R> clazz);

}
