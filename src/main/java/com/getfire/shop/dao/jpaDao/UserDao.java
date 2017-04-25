package com.getfire.shop.dao.jpaDao;

import com.getfire.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
//public interface UserDao {

    User findByLogin(String login);

//    void save(User user);
}
