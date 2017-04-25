package com.getfire.shop.service;

import com.getfire.shop.dao.jpaDao.UserDao;
import com.getfire.shop.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {
//public class UserDetailsServiceImpl  {

    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.getfire.shop.model.User user = userDao.findByLogin(login);
        if (user != null) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            for (Role role : user.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return new User(user.getLogin(), user.getPassword(), grantedAuthorities);
        }
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        System.out.println();
        System.out.println(user);
        System.out.println();
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        return null;
    }
}
