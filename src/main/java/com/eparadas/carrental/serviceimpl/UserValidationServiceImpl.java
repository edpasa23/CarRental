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

        Long id = null;

        //verifica si existe el usuario
        User x = userRepository.findById(user.getUserId()).orElse((null));

        if(!x.equals(null)){
            id = userService.findUserById(user).getUserId();
        }

        String message = "";
        if(userService.findUserByEmail(user) != null
                && userService.findUserByPhone(user) != null
                && !id.equals(userService.findUserByEmail(user).getUserId())
                && !id.equals(userService.findUserByPhone(user).getUserId())) {
            message = "Phone and Email already exist";
        }
        else if(userService.findUserByPhone(user) != null
                && !id.equals(userService.findUserByPhone(user).getUserId())) {
            message = "Phone already exist";
        }
        else if(userService.findUserByEmail(user) != null &&
                !id.equals(userService.findUserByEmail(user).getUserId())) {
            message = "Email already exist";
        }
        return message;
    }
}
