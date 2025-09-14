package com.bth06.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bth06.entity.Category;
import com.bth06.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("categories", service.findAll());
        return "admin/categories/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "admin/categories/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category, RedirectAttributes redirect) {
        service.save(category);
        redirect.addFlashAttribute("message", "Lưu thành công!");
        return "redirect:/admin/categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirect) {
        service.deleteById(id);
        redirect.addFlashAttribute("message", "Xoá thành công!");
        return "redirect:/admin/categories";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("categories", service.search(keyword));
        return "admin/categories/list";
    }
}
