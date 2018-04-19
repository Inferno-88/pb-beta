package com.octopus.pb.service.impl;


import com.octopus.pb.entity.UserApp;
import com.octopus.pb.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserApp createUser() {
        return null;
    }

    @Override
    public UserApp getUser(int id) {
        return null;
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
