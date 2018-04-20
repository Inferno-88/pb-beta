package com.octopus.pb.service.impl;


import com.octopus.pb.entity.UserApp;
import com.octopus.pb.enums.Role;
import com.octopus.pb.repository.UserRepository;
import com.octopus.pb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserApp saveUser(UserApp userApp) throws IllegalArgumentException {

        UserApp byUsername = getUserByUsername(userApp.getUsername());

        if (byUsername != null) {
            throw new IllegalArgumentException("User name already exists.");
        }

        if (userApp.getRole() == null) {
            userApp.setRole(Role.ROLE_USER);
        }

        return userRepository.save(userApp);
    }

    @Override
    public UserApp getUser(int id) {
        return null;
    }

    @Override
    public List<UserApp> getUserList() {
        return null;
    }

    @Override
    public UserApp getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean activateLogin() {
        return false;
    }

    @Override
    public boolean deactivateLogin() {
        return false;
    }

}
