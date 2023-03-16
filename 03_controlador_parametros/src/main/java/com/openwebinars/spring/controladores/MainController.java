package com.openwebinars.spring.controladores;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {

    /*@GetMapping("/")
     *//*Busca el parametro "name" dentro de la query ("/") y lo inyecta en la variable name (localhost:9000/?name=[name]
     Si queremos que el parametro que se pase a la query tenga el mismo nombre, no es necesario especificarlo en el Request:
    @RequestParam String name *//*
    public String welcome(@RequestParam("name") String name, @NotNull Model model){
        model.addAttribute("name", name);
        return "index";
    }*/

    // Si no le ponemos valor al name salta un error 400. Esto no es deseable por tanto vamos a ver dos metodos de evitar esto:
    // 1: Poniendo a required a false y un valor por defecto
    /*@GetMapping("/")
    public String welcome(@RequestParam(name = "name", required = false, defaultValue = "Mundo") String name, @NotNull Model model){
        model.addAttribute("name", name);
        return "index";
    }*/
    //2: Poniendo el valor de name (si existe), o poniendo otro valor (haciendo uso de java.util.optional)
    @GetMapping("/")
    public String welcome(@RequestParam("name") Optional<String> name, Model model){
        model.addAttribute("name", name.orElse("Mundo"));
        return "index";
    }

    @GetMapping("/info")
    public String informacion(@NotNull Model model){
        String info = "Soy Amador y estoy aprendiendo a generar diferentes vistas con un controlador";
        model.addAttribute("info", info);
        return "info";
    }
}
