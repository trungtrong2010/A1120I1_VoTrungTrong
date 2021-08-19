package com.example.user.model.repository;

import com.example.user.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user", nativeQuery = true)
    Page<User> findAll(Pageable pageable);

    @Query(value = "select * from user where user.name like %?1%", nativeQuery = true)
    Page<User> findByNameContaining(String name, Pageable pageable);

    Page<User> findByNameContainingAndTypeUser_Id(String name, int idTypeUser, Pageable pageable);

    Page<User> findByTypeUser_Id(int id, Pageable pageable);

    List<User> findByPhoneNumber(String number);
}
