package com.codegym.furama.model.repository.user;

import com.codegym.furama.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
