package com.octopus.pb.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @PostMapping("/test")
    public String testController() {

        return "Admin role confirmed.";
    }

}
