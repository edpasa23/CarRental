package com.eparadas.carrental.serviceimpl;

import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.repository.UserRepository;
import com.eparadas.carrental.service.UserService;
import com.eparadas.carrental.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            Optional<User> aux = userService.findUserById(user.getUserId());
            if(aux.isPresent()){
                id = aux.get().getUserId();
            }
        }

        String message = "";

        if(userService.findUserByPhone(user.getPhone()) != null
                && id != (userService.findUserByPhone(user.getPhone()).getUserId())) {
            message = message + " *Phone already exist";
        }
        if(userService.findUserByEmail(user.getEmail()) != null &&
                id != (userService.findUserByEmail(user.getEmail()).getUserId())) {
            message = message + " *Email already exist";
        }
        if(userService.findUserByUsername(user.getUsername()) != null &&
                id != (userService.findUserByUsername(user.getUsername()).getUserId())) {
            message = message + " *Username already exist";
        }
        return message;
    }
}
