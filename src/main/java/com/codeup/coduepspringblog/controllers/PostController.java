package com.codeup.coduepspringblog.controllers;

import com.codeup.coduepspringblog.services.EmailService;
import com.codeup.coduepspringblog.models.Post;
import com.codeup.coduepspringblog.models.User;
import com.codeup.coduepspringblog.repositories.PostRepository;
import com.codeup.coduepspringblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;
    private final EmailService emailService;


    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
    }



    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);

        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String post(@PathVariable Long id, Model model) {
        Post post = postsDao.findById(id).get();
        User user = post.getUser();
        model.addAttribute("post", post);
        model.addAttribute("email", user.getEmail());
        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());

        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        Post post = postsDao.findById(id).get();
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable Long id, @ModelAttribute Post post) {
        Post editPost = postsDao.findById(id).get();
        editPost.setBody(post.getBody());
        editPost.setTitle(post.getTitle());
        postsDao.save(editPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable Long id, @ModelAttribute Post post) {
        Post deletePost = postsDao.findById(id).get();
        postsDao.delete(deletePost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postsDao.save(post);
        emailService.prepareAndSend(post,"You created a new post!", "Title: " + post.getTitle() + "\nBody: " + post.getBody());
        return "redirect:/posts";
    }


}
