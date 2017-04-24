package com.getfire.shop.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@ToString
public class User extends AbstractModel {

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Transient
    private String confirmPassword;


}
