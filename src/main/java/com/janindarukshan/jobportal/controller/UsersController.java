package com.janindarukshan.jobportal.controller;

import com.janindarukshan.jobportal.entity.Users;
import com.janindarukshan.jobportal.entity.UsersType;
import com.janindarukshan.jobportal.service.UserService;
import com.janindarukshan.jobportal.service.UsersTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {

    private final UsersTypeService usersTypeService;
    private final UserService userService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService, UserService userService) {
        this.usersTypeService = usersTypeService;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users) {
//        System.out.println("users:" + users);
        userService.addNew(users);
        return "dashboard";
    }
}
