package com.eparadas.carrental.repository;

import com.eparadas.carrental.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Login Methods

    User findByUsername(String username);

    //

    User findByEmail(String email);

    User findByPhone(String phone);

}
