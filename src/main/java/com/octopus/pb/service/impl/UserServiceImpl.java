package com.octopus.pb.service.impl;


import com.octopus.pb.entity.security.RoleApp;
import com.octopus.pb.entity.security.UserApp;
import com.octopus.pb.enums.RoleType;
import com.octopus.pb.repository.RoleRepository;
import com.octopus.pb.repository.UserRepository;
import com.octopus.pb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public UserApp saveUser(UserApp userApp) throws IllegalArgumentException {

        checkUserNotExist(userApp);
        checkCorrectRole(userApp);

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
    public List<RoleApp> getRoleList() {
        return roleRepository.findAll();
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

    private boolean checkUserNotExist(UserApp userApp) {
        UserApp byUsername = getUserByUsername(userApp.getUsername());

        if (byUsername != null) {
            throw new IllegalArgumentException("User name already exists.");
        }

        return true;
    }

    private boolean checkCorrectRole(UserApp userApp) {

        List<String> roleList = roleRepository.findAll().stream()
                .map(r -> r.getAuthority())
                .collect(Collectors.toList());

        roleList.forEach(r -> log.info("roleList item {}", r));

        List<String> userRoleList = userApp.getRoleAppSet().stream()
                .map(ur -> ur.getAuthority())
                .collect(Collectors.toList());

        for(String userRoleString : userRoleList) {
            log.info("useeRoleString {}", userRoleString);
            if (!roleList.contains(userRoleString)) {
                throw new IllegalArgumentException("Specified role " +userRoleString+ " does not exist.");
            }
        }

        return true;
    }

}
