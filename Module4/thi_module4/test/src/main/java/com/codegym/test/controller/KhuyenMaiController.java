package com.codegym.test.controller;

import com.codegym.test.model.entity.KhuyenMai;
import com.codegym.test.model.service.IKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class KhuyenMaiController {

    @Autowired
    private IKhuyenMaiService khuyenMaiService;

    @GetMapping(value = {"", "/list"})
    public String list(@RequestParam(value = "discount", defaultValue = "") String discount,
                       @RequestParam(value = "startDate", defaultValue = "") String startDate,
                       @RequestParam(value = "endDate", defaultValue = "") String endDate,Model model) {
        model.addAttribute("discount", discount);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("khuyenMais", this.khuyenMaiService.find3Truong(discount,startDate,endDate));
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("khuyenMai", new KhuyenMai());
        return "save";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("khuyenMai", this.khuyenMaiService.findById(id));
        return "save";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute KhuyenMai khuyenMai, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "save";
        }
        this.khuyenMaiService.save(khuyenMai);
        redirectAttributes.addFlashAttribute("msg", "Đã lưu khuyến mãi: " + khuyenMai.getTitle());
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        this.khuyenMaiService.delete(this.khuyenMaiService.findById(id));
        return "list";
    }
}
