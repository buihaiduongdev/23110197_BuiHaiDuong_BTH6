package com.bth06.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bth06.entity.User;
import com.bth06.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    @Autowired private UserService service;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("users", service.findAll());
        return "admin/users/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "admin/users/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("user", service.findById(id));
        return "admin/users/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user, RedirectAttributes ra) {
        service.save(user);
        ra.addFlashAttribute("message", "Lưu User thành công!");
        return "redirect:/admin/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes ra) {
        service.deleteById(id);
        ra.addFlashAttribute("message", "Xoá User thành công!");
        return "redirect:/admin/users";
    }
    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("users", service.search(keyword));
        return "admin/users/list";
    }

}
