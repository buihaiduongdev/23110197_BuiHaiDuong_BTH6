package com.bth06.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bth06.service.UserService;

@Controller
public class LoginController {
    @Autowired private UserService userService;

    @GetMapping("/login")
    public String form() { return "web/login"; }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes ra) {
        return userService.login(username, password)
                .map(u -> {
                    session.setAttribute("account", u);
                    return "ADMIN".equalsIgnoreCase(u.getRole())
                           ? "redirect:/admin/categories"
                           : "redirect:/";
                })
                .orElseGet(() -> {
                    ra.addFlashAttribute("error", "Sai tài khoản hoặc mật khẩu");
                    return "redirect:/login";
                });
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
