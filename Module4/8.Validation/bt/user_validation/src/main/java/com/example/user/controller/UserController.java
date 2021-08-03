package com.example.user.controller;


import com.example.user.model.entity.User;
import com.example.user.model.service.ITypeUserService;
import com.example.user.model.service.IUserService;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private ITypeUserService typeUserService;
    @Autowired
    private IUserService userService;

    @GetMapping("/listUser")
    private String showList(@RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                            @RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "idTypeUser", defaultValue = "0") int idTypeUser, Model model) {
        Sort sort = Sort.by("name").and(Sort.by("age"));
        model.addAttribute("nameSearch", nameSearch);
//        model.addAttribute("typeUser", this.typeUserService.findById(idTypeUser));
        model.addAttribute("idTypeUser", idTypeUser);
        model.addAttribute("typeUsers", this.typeUserService.findAll());
//        model.addAttribute("page", page);
        if (nameSearch.equals("")) {
            if (idTypeUser == 0) {
                model.addAttribute("users", userService.findAll(PageRequest.of(page - 1, 2, sort)));
            } else {
                model.addAttribute("users", this.userService.findByTypeUser_Id(idTypeUser, PageRequest.of(page - 1, 2, sort)));
            }
        } else {
            if (idTypeUser == 0) {
                model.addAttribute("users", this.userService.findByNameContaining(nameSearch, PageRequest.of(page - 1, 2, sort)));
            } else {
                model.addAttribute("users", this.userService.findByNameContainingAndTypeUser_Id(nameSearch, idTypeUser, PageRequest.of(page - 1, 2, sort)));
            }
        }
        return "list";
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("typeUsers", this.typeUserService.findAll());
        return "create";
    }

    @PostMapping("/save")
    private String save(@Valid User user, BindingResult bindingResult, Model model) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("typeUsers", this.typeUserService.findAll());
            return "create";
        }
        this.userService.save(user);
        return "redirect:/user/listUser";
    }

    @GetMapping("/{id}/detail")
    private String detail(@PathVariable int id, Model model) {
        model.addAttribute("user", this.userService.findById(id));
        return "detail";
    }

    @GetMapping("/{id}/edit")
    private String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("user", this.userService.findById(id));
        model.addAttribute("typeUsers", this.typeUserService.findAll());
        return "create";
    }

    @GetMapping("/{id}/delete")
    private String showformDelete(@PathVariable int id, Model model) {
        model.addAttribute("user", this.userService.findById(id));
        return "delete";
    }

    @PostMapping("/remove")
    private String remove(User user) {
        this.userService.remove(user);
        return "redirect:/user/listUser";
    }
}
