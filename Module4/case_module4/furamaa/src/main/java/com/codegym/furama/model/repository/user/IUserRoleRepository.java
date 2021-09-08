package com.codegym.furama.model.repository.user;

import com.codegym.furama.model.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRoleRepository extends JpaRepository<UserRole,Integer> {
}
