package com.getfire.shop.service.implementations;

import com.getfire.shop.dao.RoleDao;
import com.getfire.shop.dao.UserDao;
import com.getfire.shop.model.Role;
import com.getfire.shop.model.User;
import com.getfire.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private RoleDao roleDao;

    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder encoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.encoder = encoder;
    }


    @Transactional
    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Transactional
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
