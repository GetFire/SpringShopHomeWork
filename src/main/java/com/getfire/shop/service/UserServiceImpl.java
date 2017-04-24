package com.getfire.shop.service;

import com.getfire.shop.dao.UserDao;
import com.getfire.shop.model.Role;
import com.getfire.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        userDao.save(user);
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }
}
