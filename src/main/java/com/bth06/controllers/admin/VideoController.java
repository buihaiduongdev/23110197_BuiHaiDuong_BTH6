package com.bth06.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bth06.entity.Video;
import com.bth06.service.CategoryService;
import com.bth06.service.VideoService;

@Controller
@RequestMapping("/admin/videos")
public class VideoController {
    @Autowired private VideoService videoService;
    @Autowired private CategoryService categoryService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("videos", videoService.findAll());
        return "admin/videos/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("video", new Video());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/videos/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("video", videoService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "admin/videos/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Video video, RedirectAttributes ra) {
        videoService.save(video);
        ra.addFlashAttribute("message", "Lưu Video thành công!");
        return "redirect:/admin/videos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes ra) {
        videoService.deleteById(id);
        ra.addFlashAttribute("message", "Xoá Video thành công!");
        return "redirect:/admin/videos";
    }
    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("videos", videoService.search(keyword));
        return "admin/videos/list";
    }

}
