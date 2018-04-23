package com.octopus.pb.service;


import com.octopus.pb.entity.security.UserApp;

import java.util.List;

public interface UserService {

    UserApp saveUser(UserApp userApp);

    UserApp getUser(int id);

    List<UserApp> getUserList();

    UserApp getUserByUsername(String username);

    boolean deleteUser(int id);

    boolean activateLogin();

    boolean deactivateLogin();
    
}
