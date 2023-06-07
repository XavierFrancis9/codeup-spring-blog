package com.codeup.coduepspringblog.controllers;

import com.codeup.coduepspringblog.models.Post;
import com.codeup.coduepspringblog.models.User;
import com.codeup.coduepspringblog.repositories.PostRepository;
import com.codeup.coduepspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;


    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }



    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);

        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String post(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        Post post = postsDao.findById(id).get();
        User user = post.getUser();
        model.addAttribute("email", user.getEmail());
        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String create() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title, String body, Model model) {
        model.addAttribute("title", title);
        model.addAttribute("body", body);
        User user = usersDao.findById(1L).get();
        Post post = new Post(user,title, body);
        postsDao.save(post);
        return "redirect:/posts";
    }


}
