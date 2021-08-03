package com.example.user.model.repository;

import com.example.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User,Integer> {
}
