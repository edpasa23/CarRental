package com.eparadas.carrental.service;

import com.eparadas.carrental.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> listAll();

    public void save(User user);

    public void delete(User user);

    public void register(User user);

    public Optional<User> findUserById(Long userId);

    public User findUserByEmail(String email);

    public User findUserByPhone(String phone);

    public User findUserByUsername(String username);




}
