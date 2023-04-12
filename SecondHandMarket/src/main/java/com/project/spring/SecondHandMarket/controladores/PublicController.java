package com.project.spring.SecondHandMarket.controladores;

import com.project.spring.SecondHandMarket.modelo.Producto;
import com.project.spring.SecondHandMarket.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/public")
public class PublicController {
    @Autowired
    ProductoServicio productoServicio;

    @ModelAttribute
    public List<Producto> productosNovendidos(){
        return productoServicio.productosSinVender();
    }

    @GetMapping({"/", "/index"})
    public String index (Model model, @RequestParam(name="q", required = false) String query){
        if(query != null)
            model.addAttribute("productos", productoServicio.buscar(query));
        return "index";
    }

    @GetMapping("/producto/{id}")
    public String muestraProducto(Model model, @PathVariable Long id){
        Producto result = productoServicio.findById(id);
        if(result != null)
            model.addAttribute("producto", result);
        return "redirect:/public";
    }
}
