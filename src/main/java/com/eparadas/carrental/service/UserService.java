package com.eparadas.carrental.service;

import com.eparadas.carrental.domain.User;
import java.util.List;

public interface UserService {

    public List<User> listAll();

    public void save(User user);

    public void delete(User user);

    public User findUserById(User user);

    public User findUserByEmail(User user);

    public User findUserByPhone(User user);

}
