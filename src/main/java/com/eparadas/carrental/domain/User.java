package com.eparadas.carrental.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Table(name = "user")
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

/*
    @NotEmpty(message = "*Please provide a username")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "*Please provide a password")
    @Column(name = "password")
    private String password;

    @NotEmpty(message = "*Please provide a password")
    @Column(name = "passwordConfirm")
    private String passwordConfirm;
*/

    @NotEmpty(message = "*Please provide a name")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "*Please provide a last name")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "*Please provide a address")
    @Column(name = "address")
    private String address;

    @NotEmpty(message = "*Please provide a city")
    @Column(name = "city")
    private String city;

    @NotEmpty(message = "*Please provide a phone")
    @Column(unique = true,name = "phone")
    private String phone;

    @NotEmpty(message = "*Please provide a email")
    @Column(unique = true, name = "email")
    @Email(message = "*Please provide a email")
    private String email;

/*    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Role> role;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Set<Booking> booking;*/

}
