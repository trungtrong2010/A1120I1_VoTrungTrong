package com.example.blog.model.repository;

import com.example.blog.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByNameContaining(String name);
}
