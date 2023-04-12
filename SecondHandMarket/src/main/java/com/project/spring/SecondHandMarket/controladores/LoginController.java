package com.project.spring.SecondHandMarket.controladores;

import com.project.spring.SecondHandMarket.modelo.Usuario;
import com.project.spring.SecondHandMarket.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String welcome(){
        return "redirect:/public/"; //listado de todos los productos
    }

    @GetMapping("/auth/login")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/auth/register")
    public String register(@ModelAttribute Usuario usuario){
        usuarioServicio.registrar(usuario);
        return "redirect:/auth/login";
    }
}
