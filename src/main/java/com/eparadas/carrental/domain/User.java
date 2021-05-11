package com.eparadas.carrental.domain;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.util.List;
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

    @NotEmpty(message = "*Please provide a username")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "*Please provide a password")
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column
    private String name;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @NotEmpty
    @Column(name = "city")
    private String city;

    @NotEmpty
    @Column(unique = true,name = "phone")
    @NumberFormat
    private String phone;

    @NotEmpty
    @Column(unique = true, name = "email")
    @Email
    private String email;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Role> role;

    /*
    @OneToOne
    @JoinColumn(name = "user_id")
    private Set<Booking> booking;*/

    /*
    @NotEmpty(message = "*Please provide a password")
    @Column(name = "passwordConfirm")
    private String passwordConfirm;
*/


}
