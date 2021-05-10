package com.eparadas.carrental.serviceimpl;

import com.eparadas.carrental.domain.Role;
import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.repository.UserRepository;
import com.eparadas.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //Methods for Login

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        for(Role role : user.getRole()){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthoritySet);

    }

    //

    @Override
    @Transactional(readOnly = true)
    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(User user) {
        return userRepository.findById(user.getUserId()).orElse((null));
    }

    @Transactional(readOnly = true)
    public User findUserByEmail(User user) {
        User userAux = userRepository.findByEmail(user.getEmail());
        return userAux;
    }

    @Transactional(readOnly = true)
    public User findUserByPhone(User user) {
        User userAux = userRepository.findByPhone(user.getPhone());
        return userAux;
    }

}