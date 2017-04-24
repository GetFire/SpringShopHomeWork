package com.getfire.shop.dao;

import com.getfire.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
