package com.blog.blogging.controller;

import com.blog.blogging.util.ArticleFileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GuestController {
    @Autowired
    private ArticleFileStorage storage;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("articles", storage.loadAll());
        return "home";
    }

    @GetMapping("/article/{id}")
    public String viewArticle(@PathVariable String id, Model model) {
        model.addAttribute("article", storage.load(id));
        return "article";
    }
}
