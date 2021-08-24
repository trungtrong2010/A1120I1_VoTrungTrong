package com.example.blog.controller;
import com.example.blog.model.entity.Blog;
import com.example.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {

    @Autowired
    IBlogService blogService;

    @GetMapping("/search/{nameSearch}")
    public ResponseEntity<List<Blog>> showList(@PathVariable("nameSearch") String nameSearch) {
        List<Blog> blogs = this.blogService.findAllByNameContaining(nameSearch);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/listRest")
    public ResponseEntity<List<Blog>> list() {
        List<Blog> blogs = this.blogService.findAll();
        return new ResponseEntity<>((blogs),HttpStatus.OK);
    }
}
