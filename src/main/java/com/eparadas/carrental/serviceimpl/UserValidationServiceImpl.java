package com.eparadas.carrental.serviceimpl;

import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.repository.UserRepository;
import com.eparadas.carrental.service.UserService;
import com.eparadas.carrental.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidationServiceImpl implements UserValidationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;    

    @Override
    public String validateUser(User user){

        Long id = user.getUserId();
        User x = null;

        //verifica si existe el usuario
        if(id != null) {
            x = userRepository.findById(user.getUserId()).orElse((null));
        }

        if(x != null){
            id = userService.findUserById(user).getUserId();
        }

        String message = "";

        if(userService.findUserByPhone(user) != null
                && id != userService.findUserByPhone(user).getUserId()) {
            message = message + " *Phone already exist";
        }
        if(userService.findUserByEmail(user) != null &&
                id != userService.findUserByEmail(user).getUserId()) {
            message = message + " *Email already exist";
        }
        if(userService.findUserByUsername(user) != null &&
                id != userService.findUserByUsername(user).getUserId()) {
            message = message + " *Username already exist";
        }
        return message;
    }
}
