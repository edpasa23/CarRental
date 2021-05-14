package com.eparadas.carrental.service;

import com.eparadas.carrental.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> listAll();

    void save(User user);

    void delete(User user);

    void register(User user);

    Optional<User> findUserById(Long userId);

    User findUserByEmail(String email);

    User findUserByPhone(String phone);

    User findUserByUsername(String username);




}
