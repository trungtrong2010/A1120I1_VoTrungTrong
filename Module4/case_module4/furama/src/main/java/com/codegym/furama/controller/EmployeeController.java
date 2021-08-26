package com.codegym.furama.controller;

import com.codegym.furama.model.entity.employee.Employee;
import com.codegym.furama.model.repository.employee.DivisionRepository;
import com.codegym.furama.model.repository.employee.EducationDegreeRepository;
import com.codegym.furama.model.repository.employee.PositionRepository;
import com.codegym.furama.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "1") int page,
                       @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch, Model model) {
        Sort sort = Sort.by("name").and(Sort.by("dayOfBirth"));
        if (nameSearch == null) {
            model.addAttribute("employees", this.employeeService.findAll(PageRequest.of(page - 1, 2, sort)));
        } else {
            model.addAttribute("nameSearch", nameSearch);
            model.addAttribute("employees", this.employeeService.findAllByNameContaining(nameSearch, PageRequest.of(page - 1, 2, sort)));
        }
        return "employee/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }
}
