package com.eparadas.carrental.web;

import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;



@Controller
public class ControllerCarRental {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidationService userValidationService;

    //********USER METHODS*****************

    @GetMapping("createAccount")
    public String createAccount(User user){
        return "create-account";
    }

    //Registro (valida y asigna rol de USER)
    @PostMapping("/signUp")
    public String signUp(@Valid User user, BindingResult result, Errors error) {
        String err = userValidationService.validateUser(user);
        if (!err.isEmpty()) {
            ObjectError validationError = new ObjectError("globalError", err);
            result.addError(validationError);
        }
        if (error.hasErrors()) {
            return "create-account";
        }
        userService.register(user);
        return "correct-registration";
    }




}