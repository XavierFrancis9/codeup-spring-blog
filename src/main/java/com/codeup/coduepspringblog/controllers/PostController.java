package com.codeup.coduepspringblog.controllers;

import com.codeup.coduepspringblog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")

    public String posts(Model model) {
        Post p2 = new Post("Whats Up", "I'm bored so im making a post");
        Post p3 = new Post("Hey Everyone", "Im just writing a post because");
        List<Post> posts = new ArrayList<>();

        posts.add(p2);
        posts.add(p3);

        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")

    public String post(@PathVariable Long id, Model model) {
        Post p1 = new Post("YOOO", "This is my first post!");
        model.addAttribute("title", p1.getTitle());
        model.addAttribute("body", p1.getBody());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String create() {
        return "posts/index";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@RequestParam String title, String body, Model model) {

        return "/posts/index";
    }
}
