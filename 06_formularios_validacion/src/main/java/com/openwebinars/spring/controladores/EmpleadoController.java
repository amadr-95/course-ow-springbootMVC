package com.openwebinars.spring.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.openwebinars.spring.modelo.Empleado;
import com.openwebinars.spring.servicios.EmpleadoService;

import javax.validation.Valid;

@Controller
public class EmpleadoController {
    @Autowired
    private EmpleadoService servicio;

	@GetMapping({"/", "empleado/list"})
    public String listado(Model model){
        model.addAttribute("listaEmpleados", servicio.findAll());
        return "list";
    }

    @GetMapping("/empleado/new")
    public String nuevoEmpleadoForm(Model model){
        model.addAttribute("empleadoForm", new Empleado());
        return "form";
    }

    @PostMapping("/empleado/new/submit")
    public String nuevoEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm") Empleado nuevoEmpleado, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "form";
        else{
            servicio.add(nuevoEmpleado);
            return "redirect:/empleado/list";
        }

    }
    //-------Metodos nuevos para la parte de edicion------
    @GetMapping("/empleado/edit/{id}")
    public String editarEmpleadoForm(@PathVariable long id, Model model){
        Empleado empleado = servicio.buscarID(id);
        if(empleado != null){
            model.addAttribute("empleadoForm", empleado);
            return "form";
            //si el ID no existe, lo redirigimos para que cree uno nuevo
        }else
            return "redirect:/empleado/new";
    }

    @PostMapping("/empleado/edit/submit")
    public String editarEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm") Empleado empleado, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "form";
        else{
            servicio.edit(empleado);
            return "redirect:/empleado/list";
        }
    }

}
