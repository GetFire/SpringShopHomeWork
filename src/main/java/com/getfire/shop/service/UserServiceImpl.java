package com.getfire.shop.service;

import com.getfire.shop.dao.jpaDao.RoleDao;
import com.getfire.shop.dao.jpaDao.UserDao;
import com.getfire.shop.model.Role;
import com.getfire.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

//@Service
public class UserServiceImpl implements UserService {

//    private UserDao userDao;
//
//    private RoleDao roleDao;
//
//    private BCryptPasswordEncoder encoder;
//
//    @Autowired
//    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder encoder) {
//        this.userDao = userDao;
//        this.roleDao = roleDao;
//        this.encoder = encoder;
//    }
//
//    public UserServiceImpl() {
//    }
//
//    public UserDao getUserDao() {
//        return userDao;
//    }
//
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//
//    public BCryptPasswordEncoder getEncoder() {
//        return encoder;
//    }
//
//    @Autowired
//    public void setEncoder(BCryptPasswordEncoder encoder) {
//        this.encoder = encoder;
//    }
//
//    @Transactional
//    public void saveUser(User user) {
//        user.setPassword(encoder.encode(user.getPassword()));
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleDao.getOne(1L));
//        user.setRoles(roles);
//        userDao.save(user);
//    }
//
//    @Transactional
//    public User findByLogin(String login) {
//        return userDao.findByLogin(login);
//    }
}
