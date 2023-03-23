package com.openwebinars.spring.controladores;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {

    @GetMapping("/")
    public String welcome(){
        return "gym/index";
    }

    @GetMapping("/supplementation")
    public String supplemetation(){
        return "gym/pages/supplementation";
    }

    @GetMapping("/training")
    public String training(){
        return "gym/pages/training";
    }

    @GetMapping("/app")
    public String app(){
        return "gym/pages/app";
    }

    @GetMapping("/register")
    public String register(){
        return "gym/pages/register";
    }

    @GetMapping("/login")
    public String login(){
        return "gym/pages/login";
    }

    @GetMapping("/logged")
    public String logged(){
        return "gym/pages/logged";
    }

}
