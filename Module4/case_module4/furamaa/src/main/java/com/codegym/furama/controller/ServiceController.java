package com.codegym.furama.controller;

import com.codegym.furama.model.entity.service.Service;
import com.codegym.furama.model.repository.service.IRentTypeRepository;
import com.codegym.furama.model.repository.service.IServiceTypeRepository;
import com.codegym.furama.model.service.IServiceService;
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
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @GetMapping("/list")
    public String list(@RequestParam(name = "page", defaultValue = "1") int page, Model model,
                       @RequestParam(name = "nameSearch", defaultValue = "") String nameSearch,
                       @RequestParam(name = "idRentTypeSearch", defaultValue = "") Optional<Integer> idRentTypeSearch,
                       @RequestParam(name = "idServiceTypeSearch", defaultValue = "") Optional<Integer> idServiceTypeSearch) {
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("idRentTypeSearh", idRentTypeSearch.orElse(null));
        model.addAttribute("idServiceTypeSearch", idServiceTypeSearch.orElse(null));
        model.addAttribute("rentTypes", this.rentTypeRepository.findAll());
        model.addAttribute("serviceTypes", this.serviceTypeRepository.findAll());
        Sort sort = Sort.by("name").and(Sort.by("cost"));
        model.addAttribute("services", this.serviceService.findAllSearch3Var(nameSearch, idRentTypeSearch, idServiceTypeSearch, PageRequest.of(page - 1, 2, sort)));
        return "service/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("service", this.serviceService.findById(id));
        return "service/detail";
    }

    @GetMapping("/delete/{id}")
    public String formDelete(@PathVariable Integer id, Model model) {
        model.addAttribute("service", this.serviceService.findById(id));
        return "service/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") Integer id, RedirectAttributes redirectAttributes) {
        Service service = this.serviceService.findById(id);
        this.serviceService.delete(service);
        redirectAttributes.addFlashAttribute("msg", "Deleted service name: " + service.getName());
        return "redirect:/service/list";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("rentTypes", this.rentTypeRepository.findAll());
        model.addAttribute("serviceTypes", this.serviceTypeRepository.findAll());
        model.addAttribute("service", this.serviceService.findById(id));
        return "service/save";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("rentTypes", this.rentTypeRepository.findAll());
        model.addAttribute("serviceTypes", this.serviceTypeRepository.findAll());
        model.addAttribute("service", new Service());
        return "service/save";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("service") Service service, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
//        new Service().validate(service, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("rentTypes", this.rentTypeRepository.findAll());
            model.addAttribute("serviceTypes", this.serviceTypeRepository.findAll());
            return "service/save";
        }
        this.serviceService.save(service);
        redirectAttributes.addFlashAttribute("msg", "Saved service name: " + service.getName());
        return "redirect:/service/list";
    }
}
