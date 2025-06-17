package com.blog.blogging.controller;

import com.blog.blogging.model.Article;
import com.blog.blogging.util.ArticleFileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
@SessionAttributes("isAdmin")
public class AdminController {
    @Autowired
    private ArticleFileStorage storage;

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("articles", storage.loadAll());
        return "dashboard";
    }

    @GetMapping("/new")
    public String newArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "new";
    }

    @PostMapping("/new")
    public String publishArticle(@ModelAttribute Article article) throws IOException {
        storage.save(article);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute("article", storage.load(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateArticle(@ModelAttribute Article article) throws IOException {
        storage.save(article);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable String id) {
        storage.delete(id);
        return "redirect:/admin";
    }
}
