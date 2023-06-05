package com.codeup.coduepspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    // Get Request Mapping for /test
    @GetMapping("/test")
    // Set Response content type text/html
    @ResponseBody
    // define method that will return text/html
    public String test() {
        return "This is a test";
    }

    @GetMapping("/parks/{park}/{message}")
    @ResponseBody
    public String parks(@PathVariable String park, @PathVariable String message) {
        return "<h1>Welcome to " + park + "!</h1>" + "<p>" + message + "</p>";
    }

}
