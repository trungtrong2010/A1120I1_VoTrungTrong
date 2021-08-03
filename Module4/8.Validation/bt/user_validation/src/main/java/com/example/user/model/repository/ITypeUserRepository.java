package com.example.user.model.repository;

import com.example.user.model.entity.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeUser extends JpaRepository<TypeUser,Integer> {
}
