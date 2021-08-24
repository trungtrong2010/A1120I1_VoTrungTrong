package com.example.blog.model.service.impl;

import com.example.blog.model.entity.Blog;
import com.example.blog.model.repository.IBlogRepository;
import com.example.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
        this.blogRepository.delete(blog);
    }

    @Override
    public List<Blog> findAllByNameContaining(String name) {
        return this.blogRepository.findAllByNameContaining(name);
    }
}
