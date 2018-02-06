package com.octopus.pb.service.impl;


import com.octopus.pb.model.User;
import com.octopus.pb.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class BaseUserService implements UserService{

    @Override
    public User createUser() {
        return null;
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
