package com.eparadas.carrental.web;

import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.service.UserService;
import com.eparadas.carrental.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ControllerUsers {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidationService userValidationService;

    @GetMapping("/usersList")
    public String viewUsers(Model model){
        List<User> clientsList = userService.listAll();
        model.addAttribute("userList",clientsList);
        return "user-list";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(User user){
        userService.delete(user);
        return "redirect:/usersList";
    }

    @GetMapping("/addUser")
    public String addUser(User user){
        return "add-modify-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid User user, BindingResult result, Errors error) {
        String err = userValidationService.validateUser(user);
        if (!err.isEmpty()) {
            ObjectError validationError = new ObjectError("globalError", err);
            result.addError(validationError);
        }
        if (error.hasErrors()) {
            System.out.println(error.toString());
            return "add-modify-user";
        }
        userService.save(user);
        return "redirect:/usersList";
    }

    @GetMapping("/editUser")
    public String editUser(User user,Model model){
        Optional<User> aux = userService.findUserById(user.getUserId());

        if(aux.isPresent()){
            user = aux.get();
        }

        model.addAttribute("user", user);
        return "add-modify-user";
    }

}
