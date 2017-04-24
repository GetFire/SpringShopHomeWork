package com.getfire.shop.dao;

import com.getfire.shop.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User findByLogin(String login);

    void save(User user);
}
