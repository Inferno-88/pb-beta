package com.octopus.pb.repository;

import com.octopus.pb.entity.security.RoleApp;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<RoleApp, Integer> {

    @Override
    List<RoleApp> findAll();

    @Override
    RoleApp save(RoleApp roleApp);

    RoleApp findRoleAppByAuthority(String authority);
}
