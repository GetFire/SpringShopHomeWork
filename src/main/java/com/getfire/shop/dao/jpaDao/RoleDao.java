package com.getfire.shop.dao.jpaDao;

import com.getfire.shop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
//public interface RoleDao  {
}
