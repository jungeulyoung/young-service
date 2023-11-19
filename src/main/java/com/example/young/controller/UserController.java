package com.example.young.controller;

import com.example.young.model.User;
import com.example.young.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello, this is a GET request!");
    }


    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/join")
    public User joinUser(@RequestBody User userInfo){
        System.out.println(userInfo);
        System.out.println("----------");
//        userService.joinUser(userInfo);
        return userInfo;
    }
}
