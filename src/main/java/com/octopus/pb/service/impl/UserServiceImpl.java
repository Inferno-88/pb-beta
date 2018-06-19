package com.octopus.pb.service.impl;


import com.octopus.pb.entity.security.RoleApp;
import com.octopus.pb.entity.security.UserApp;
import com.octopus.pb.repository.RoleRepository;
import com.octopus.pb.repository.UserRepository;
import com.octopus.pb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
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
        if (checkUserExist(userApp)) {
            throw new IllegalArgumentException("User name already exists.");
        }
        if (!checkCorrectRole(userApp)) {
            throw new IllegalArgumentException("Specified role does not exist.");
        }

        if (userApp.getRoleAppSet().size() == 0) {
            throw new IllegalArgumentException("User role was not specified");
        }

        setRoleSet(userApp);

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

    private boolean checkUserExist(UserApp userApp) {
        UserApp byUsername = getUserByUsername(userApp.getUsername());

        if (byUsername != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkCorrectRole(UserApp userApp) {
        List<String> roleList = roleRepository.findAll().stream()
                .map(r -> r.getAuthority())
                .collect(Collectors.toList());

        List<String> userRoleList = userApp.getRoleAppSet().stream()
                .map(ur -> ur.getAuthority())
                .collect(Collectors.toList());

        for(String userRoleString : userRoleList) {
            if (!roleList.contains(userRoleString)) {
                return false;
            }
        }

        return true;
    }

    private void setRoleSet(UserApp userApp) {
        userApp.getRoleAppSet().stream()
//                .forEach(r -> log.info("SET_ROLE_ID: {}", roleRepository.findRoleAppByAuthority(r.getAuthority()).getId()));
                .peek(r -> r.setId(roleRepository.findRoleAppByAuthority(r.getAuthority()).getId()));
    }

}
