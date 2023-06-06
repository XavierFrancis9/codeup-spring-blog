package com.codeup.coduepspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceResultController {
    @GetMapping("/roll-dice/{num}")
    public String result(@PathVariable int num, Model model) {
        model.addAttribute("num", num);
        Random rand = new Random();
        int randomNum = rand.nextInt(6) + 1;
        Boolean result = null;

        if(num == randomNum) {
            result = true;
        } else {
            System.out.println(randomNum);
            result = false;
        }
        model.addAttribute("result", result);
        model.addAttribute("randomNum", randomNum);
        return "/dice/roll-result";
    }
}
