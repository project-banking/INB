package com.diaspark.INB.repository;

import com.diaspark.INB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
  Repository name is always table Bean name + Repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserById(long id);
}
