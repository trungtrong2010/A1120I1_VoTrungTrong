package com.codegym.furama.controller;

import com.codegym.furama.model.entity.employee.Employee;
import com.codegym.furama.model.repository.employee.DivisionRepository;
import com.codegym.furama.model.repository.employee.EducationDegreeRepository;
import com.codegym.furama.model.repository.employee.PositionRepository;
import com.codegym.furama.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

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
                       @RequestParam(name = "nameSearch",defaultValue = "") String nameSearch,
                       @RequestParam(name = "idDivision", defaultValue = "") Optional<Integer> idDivision,
                       @RequestParam(name = "idEducation", defaultValue = "") Optional<Integer> idEducation, Model model) {

        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("idDivision", idDivision.orElse(null));
        model.addAttribute("idEducation", idEducation.orElse(null));
        model.addAttribute("divisions", this.divisionRepository.findAll());
        model.addAttribute("educations", this.educationDegreeRepository.findAll());
        Sort sort = Sort.by("name").and(Sort.by("dayOfBirth"));
        model.addAttribute("employees", this.employeeService.findAllSearch(nameSearch, idDivision, idEducation, PageRequest.of(page - 1, 3, sort)));
        return "employee/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("divisions", this.divisionRepository.findAll());
        model.addAttribute("educationDegrees", this.educationDegreeRepository.findAll());
        model.addAttribute("positions", this.positionRepository.findAll());
        return "employee/save";
    }

    @GetMapping("/{id}/update")
    public String formUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", this.employeeService.findById(id));
        model.addAttribute("divisions", this.divisionRepository.findAll());
        model.addAttribute("educationDegrees", this.educationDegreeRepository.findAll());
        model.addAttribute("positions", this.positionRepository.findAll());
        return "employee/save";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                       Model model, RedirectAttributes redirectAttributes) {
        new Employee().validate(employee, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("divisions", this.divisionRepository.findAll());
            model.addAttribute("educationDegrees", this.educationDegreeRepository.findAll());
            model.addAttribute("positions", this.positionRepository.findAll());
            return "employee/save";
        }
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Saved employee name: " + employee.getName());
        return "redirect:/employee/list";
    }

    @GetMapping("/{id}/detail")
    public String formDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", this.employeeService.findById(id));
        return "employee/detail";
    }

    @GetMapping("/{id}/remove")
    public String formRemove(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", this.employeeService.findById(id));
        model.addAttribute("checkRemove", "remove");
        return "employee/detail";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        this.employeeService.remove(employee);
        redirectAttributes.addFlashAttribute("msg", "Deleted employee name: " + employee.getName());
        return "employee/list";
    }
}
