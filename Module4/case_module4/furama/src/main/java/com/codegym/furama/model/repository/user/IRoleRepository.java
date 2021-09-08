package com.codegym.furama.model.repository.user;

import com.codegym.furama.model.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,Integer> {
}
