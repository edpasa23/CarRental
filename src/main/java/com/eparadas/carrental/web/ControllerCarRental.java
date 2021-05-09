package com.eparadas.carrental.web;

import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;
import java.util.List;

@Controller
public class ControllerCarRental {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewUsers(Model model){
        List<User> clientsList = userService.listAll();
        model.addAttribute("userList",clientsList);
        return "index";
    }

    @GetMapping("/add")
    public String add(User user){
        return "add-client";
    }

    @PostMapping("/save")
    public String save(@Valid User user, Errors error){
        if(error.hasErrors()){
            return "add-client";
        }
        userService.save(user);
        return "redirect:/";
    }

}