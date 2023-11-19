package com.example.young.controller;

import com.example.young.model.User;
import com.example.young.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public  String home() {
        return "home";
    }

    @PostMapping("/members/new")
    public String create(User user){

        System.out.println("user = " + user.getName());
        userService.join(user);

        return "redirect:/";
    }

}
