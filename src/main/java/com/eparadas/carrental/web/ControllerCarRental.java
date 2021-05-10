package com.eparadas.carrental.web;


import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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


/*
    para poder ver quien hizo login
    @GetMapping("/usersList")
    public String viewUsers(Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User userDetails){
        List<User> clientsList = userService.listAll();
        model.addAttribute("userList",clientsList);
        return "user-list";
    }*/

    @GetMapping("/usersList")
    public String viewUsers(Model model){
        List<User> clientsList = userService.listAll();
        model.addAttribute("userList",clientsList);
        return "user-list";
    }

    @GetMapping("/addUser")
    public String addUser(User user){
        return "add-modify-user";
    }

    @GetMapping("/editUser")
    public String editUser(User user,Model model){
        user = userService.findUser(user);
        model.addAttribute("user", user);
        return "add-modify-user";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(User user){
        userService.delete(user);
        return "redirect:/usersList";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid User user, Errors error){
        if(error.hasErrors()){
            return "add-modify-user";
        }
        userService.save(user);
        return "redirect:/usersList";
    }


}