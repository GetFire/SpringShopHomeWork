package com.getfire.shop.dao;

import com.getfire.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username=:username")
    User findByUsername(@Param("username") String username);

}
