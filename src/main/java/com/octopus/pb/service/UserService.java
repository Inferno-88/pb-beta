package com.octopus.pb.service;


import com.octopus.pb.entity.User;

public interface UserService {

    User createUser();

    User getUser(int id);

    boolean deleteUser(int id);

    boolean activateLogin();

    boolean deactivateLogin();
    
}
