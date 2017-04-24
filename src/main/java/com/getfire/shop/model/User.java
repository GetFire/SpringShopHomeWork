package com.getfire.shop.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@ToString
public class User extends AbstractModel {

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Transient
    private String confirmPassword;


    public User(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = Role.USER;
    }

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = Role.USER;
    }

    public User(String login, String password, Role role, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.confirmPassword = confirmPassword;
    }






}
