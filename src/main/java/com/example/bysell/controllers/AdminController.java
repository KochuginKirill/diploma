package com.example.bysell.controllers;

import com.example.bysell.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private  final UserService userService;

    public String admin(Model model){
        model.addAttribute("users", userService.list());
        return "admin";
    }

    @PostMapping("/user/ban/{id}")
    public String userBan(@PathVariable("id") Long id){
        userService.banUser(id);
    }
}
