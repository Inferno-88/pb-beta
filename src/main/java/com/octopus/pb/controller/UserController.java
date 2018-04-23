package com.octopus.pb.controller;


import com.octopus.pb.entity.security.UserApp;
import com.octopus.pb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/sign-up")
    public String signUp(@RequestBody UserApp userApp) {

        userApp.setPassword(bCryptPasswordEncoder.encode(userApp.getPassword()));

        try {
            userApp = userService.saveUser(userApp);
        }
        catch (IllegalArgumentException e){
            return e.getMessage();
        }

        return ("Created user with ID: " + userApp.getId());
    }

}
