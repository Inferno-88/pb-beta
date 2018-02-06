package com.octopus.pb.service;


import com.octopus.pb.model.User;

public interface UserService {

    User createUser();

    boolean activateLogin();

    boolean deactivateLogin();
    
}
