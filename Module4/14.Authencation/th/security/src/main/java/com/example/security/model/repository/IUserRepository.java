package com.example.security.model.repository;

import com.example.security.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}
