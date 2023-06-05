package com.codeup.coduepspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "<h1>posts index page</h1>";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String id(@PathVariable int id) {
        return "<h1>view an individual post</h1>" +
                "<p>Your viewing post #" + id + "</p>";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "<h1>view the form for creating a post</h1>" +
                "<form>" +
                "<input name='userInput'>" +
                "<button>Submit</button" +
                "</form>";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "<h1>create a new post</h1>";
    }
}
