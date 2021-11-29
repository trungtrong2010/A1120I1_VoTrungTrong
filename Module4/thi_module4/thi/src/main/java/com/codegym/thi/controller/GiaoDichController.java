package com.codegym.thi.controller;

import com.codegym.thi.model.entity.GiaoDich;
import com.codegym.thi.model.repository.IKhachHangRepository;
import com.codegym.thi.model.service.impl.IGiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
public class GiaoDichController {

    public static HashMap<Integer, String> loaiDichVu;

    static {
        loaiDichVu = new HashMap<>();
        loaiDichVu.put(1, "Nhà đất");
        loaiDichVu.put(2, "Đất");
    }
    

    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Autowired
    private IGiaoDichService giaoDichService;


    @GetMapping(value = {"/", "/list"})
    public String list(@RequestParam(value = "name", defaultValue = "") String name,
                       @RequestParam(value = "loaiDV", defaultValue = "") String loaiDV, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("loaiDV", loaiDV);
        model.addAttribute("loaiDichVus", loaiDichVu);
        model.addAttribute("giaoDichs", this.giaoDichService.findSearch(name, loaiDV));
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("loaiDichVus", loaiDichVu);
        model.addAttribute("khachHangs", this.khachHangRepository.findAll());
        model.addAttribute("giaoDich", new GiaoDich());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute GiaoDich giaoDich, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("loaiDichVus", loaiDichVu);
            model.addAttribute("khachHangs", this.khachHangRepository.findAll());
            return "create";
        }
        redirectAttributes.addFlashAttribute("msg", "Đã thêm giao dịch thành công mã giao dịch: " + giaoDich.getId());
        this.giaoDichService.save(giaoDich);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("giaoDich", this.giaoDichService.findById(id));
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        this.giaoDichService.delete(this.giaoDichService.findById(id));
        return "redirect:/list";
    }
}
