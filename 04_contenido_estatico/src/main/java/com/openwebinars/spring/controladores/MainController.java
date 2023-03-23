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
        return "index";
    }

    @GetMapping("/supplementation")
    public String supplemetation(){
        return "pages/supplementation";
    }

    @GetMapping("/training")
    public String training(){
        return "pages/training";
    }

    @GetMapping("/app")
    public String app(){
        return "pages/app";
    }

    @GetMapping("/register")
    public String register(){
        return "pages/register";
    }

    @GetMapping("/login")
    public String login(){
        return "pages/login";
    }

    @GetMapping("/logged")
    public String logged(){
        return "pages/logged";
    }

}
