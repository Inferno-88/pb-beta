package com.octopus.pb.service;


import com.octopus.pb.entity.UserApp;

public interface UserService {

    UserApp createUser();

    UserApp getUser(int id);

    boolean deleteUser(int id);

    boolean activateLogin();

    boolean deactivateLogin();
    
}
