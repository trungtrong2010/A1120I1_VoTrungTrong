package com.ontap.demo.controller;

import com.ontap.demo.model.entity.Promotion;
import com.ontap.demo.model.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;

    @GetMapping(value = {"/", "/list"})
    public String showList(Model model) {
        model.addAttribute("promotions", promotionService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("promotion", new Promotion());
        return "save";
    }


    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("edit", "edit");
        model.addAttribute("promotion", this.promotionService.findById(id));
        return "save";
    }

    @PostMapping("/save")
    public String save(Promotion promotion) {
        this.promotionService.save(promotion);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {

        Promotion promotion = this.promotionService.findById(id);
        this.promotionService.delete(promotion);
        model.addAttribute("titleDelete", promotion.getTitle());
        return "list";
    }

    @GetMapping("/search")
    public String search(@RequestParam String startDateSearch, String endDateSearch, String detailSearch, Model model) {
        model.addAttribute("startDateSearch", startDateSearch);
        model.addAttribute("endDateSearch", endDateSearch);
        model.addAttribute("detailSearch", detailSearch);
        model.addAttribute("promotions", this.promotionService.search(startDateSearch, endDateSearch, detailSearch));
        return "list";
    }

//    @GetMapping("/{id}/remove")
//    public String formRemove(Promotion promotion) {
//        this.promotionService.delete(promotion);
//
//    }
}
