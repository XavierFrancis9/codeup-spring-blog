package com.codeup.coduepspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String sum(@PathVariable int num1, @PathVariable int num2) {
        return "<h1>" + num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String difference(@PathVariable int num1, @PathVariable int num2) {
        return "<h1>" + num1 + " - " + num2 + " = " + (num1 - num2);
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String product(@PathVariable int num1, @PathVariable int num2) {
        return "<h1>" + num1 + " * " + num2 + " = " + (num1 * num2);
    }

    @GetMapping("/divide/{num1}/and/{num2}")
    @ResponseBody
    public String quotient(@PathVariable int num1, @PathVariable int num2) {
        return "<h1>" + num1 + " / " + num2 + " = " + (num1 / num2);
    }

}
