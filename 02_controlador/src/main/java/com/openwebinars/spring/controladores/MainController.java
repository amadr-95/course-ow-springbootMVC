package com.openwebinars.spring.controladores;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/") //indica que este método se invoca cuando se produce una petición web (escucha en la ruta /)
    public String welcome(@NotNull Model model){ //Model es un Map que nos permite pasar objetos del controlador a la vista
        model.addAttribute("mensaje", "Hola a todos!");
        return "index"; //sin el .html
    }

    @GetMapping("/info")
    public String informacion(@NotNull Model model){
        String info = "Soy Amador y estoy aprendiendo a generar diferentes vistas con un controlador";
        model.addAttribute("info", info);
        return "info";
    }
}
