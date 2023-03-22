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

    /*Busca el parametro "name" dentro de la query ("/") y lo inyecta en la variable name (localhost:9000/?name=[name]
    Si queremos que el parametro que se pase a la query tenga el mismo nombre, no es necesario especificarlo en el Request:
    @RequestParam String name*/
    /*@GetMapping("/")
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
    public String welcome(@RequestParam @NotNull Optional<String> name, @NotNull Model model){
        model.addAttribute("name", name.orElse("Mundo"));
        return "index";
    }

    @GetMapping("/info")
    public String informacion(@NotNull Model model){
        String info = "Estoy aprendiendo a usar diferentes vistas con un controlador";
        model.addAttribute("info", info);
        return "info";
    }

    //Uso de @PathVariable
    @GetMapping("/saludo/{name}")
    public String saludo(@PathVariable String name, @NotNull Model model){
        model.addAttribute("saludo", "Hola, "+name);
        return "index";
    }

    /*Ejemplo para practicar: modificar el metodo welcome para que reciba dos parametros en la query
     /?firstName=[]&lastName=[]*/
    @GetMapping("/welcome")
    public String welcome(@RequestParam String firstName, @RequestParam Optional<String> lastName, @NotNull Model model){
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName.orElse("SinApellido"));
        return "welcome";
    }
    //Mismo ejemplo pero con @PathVariable
    @GetMapping("/welcome/{firstName}{lastName}")
    public String welcome(@PathVariable String firstName, @PathVariable String lastName, @NotNull Model model){
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        return "welcome";
    }
}
