package com.getfire.shop.service;

import com.getfire.shop.model.User;

public interface UserService {
    void save(User user);

    User findByLogin(String login);
}
