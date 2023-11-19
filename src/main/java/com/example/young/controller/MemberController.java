package com.example.young.controller;

import com.example.young.model.User;
import com.example.young.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    private UserService userService;

    @Autowired
    public MemberController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/members/new")
    public String CreateForm() {
        return "members/createMemberForm";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "members/memberList";
    }

}
