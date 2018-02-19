package com.octopus.pb.service;


import com.octopus.pb.model.User;

public interface UserService {

    User createUser();

    User getUser(int id);

    boolean deleteUser(int id);

    boolean activateLogin();

    boolean deactivateLogin();
    
}
