package com.eparadas.carrental.serviceimpl;

import com.eparadas.carrental.domain.Role;
import com.eparadas.carrental.domain.User;
import com.eparadas.carrental.repository.RoleRepository;
import com.eparadas.carrental.repository.UserRepository;
import com.eparadas.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    //*****************Method for Login**********************

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException(username);
        }

        ArrayList grantedAuthoritySet = new ArrayList<GrantedAuthority>();

        for(Role role : user.getRole()){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthoritySet);

    }

    //******************************************************

    @Override
    @Transactional(readOnly = true)
    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {

        User aux = userRepository.findByUsername(user.getUsername());
        user.setRole(aux.getRole());

        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public void register(User user) {

        //Encripta password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        //Guarda el rol nuevo
        Role roleAux = new Role();
        roleAux.setName("ROLE_USER");
        roleRepository.save(roleAux);

        //
        ArrayList roles = new ArrayList<GrantedAuthority>();
        roles.add(roleAux);
        user.setRole(roles);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {
        User userAux = userRepository.findByEmail(email);
        return userAux;
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByPhone(String phone) {
        User userAux = userRepository.findByPhone(phone);
        return userAux;
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        User userAux = userRepository.findByUsername(username);
        return userAux;
    }

}