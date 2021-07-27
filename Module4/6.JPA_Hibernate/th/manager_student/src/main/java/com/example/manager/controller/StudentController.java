package com.example.manager.controller;

import com.example.manager.model.entity.Student;
import com.example.manager.model.repository.IStudentRepository;
import com.example.manager.model.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/student")
@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping(value = {"", "/list"})
    private String showListStudent(Model model) {
        model.addAttribute("list", studentService.findAll());
        return "list";
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("list_class", new String[]{"full-time", "part-time"});
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/save")
    private String save(Student student) {
        studentService.save(student);
        return "redirect:/student/list";
    }

    @GetMapping("/detail")
    private String detail(@RequestParam int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "detail";
    }

    @GetMapping("/{id}/delete")
    private String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "delete";
    }

    @PostMapping("/remove")
    private String remove(Student student) {
        studentService.deleteById(student.getId());
        return "redirect:/student/list";
    }

    @GetMapping("{id}/edit")
    private String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("list_class", new String[]{"full-time", "part-time"});
        model.addAttribute("student", studentService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    private String update(Student student) {
        studentService.save(student);
        return "redirect:/student/list";
    }

    @PostMapping("/search")
    private String seach(@RequestParam String nameSearch, Model model) {
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("list", studentService.findByName(nameSearch));
        return "/list";
    }
}
