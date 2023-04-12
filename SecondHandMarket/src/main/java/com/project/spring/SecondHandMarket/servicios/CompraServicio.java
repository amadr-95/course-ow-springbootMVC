package com.project.spring.SecondHandMarket.servicios;

import com.project.spring.SecondHandMarket.modelo.Compra;
import com.project.spring.SecondHandMarket.modelo.Producto;
import com.project.spring.SecondHandMarket.modelo.Usuario;
import com.project.spring.SecondHandMarket.repositorios.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServicio {
    @Autowired
    CompraRepository repositorio;

    @Autowired
    ProductoServicio productoServicio; //una compra puede estar compuesta de varios servicios

    public Compra insertar(Compra c, Usuario u){
        c.setPropietario(u);
        return repositorio.save(c);
    }

    public Compra insertar(Compra c){
        return repositorio.save(c);
    }

    //añadir un producto a una compra
    public Producto addProductoCompra(Producto p, Compra c){
        p.setCompra(c);
        return productoServicio.editar(p);
    }

    public Compra findById(long id){
        return repositorio.findById(id).orElse(null);
    }

    public List<Compra> todas(){
        return repositorio.findAll();
    }

    public List<Compra> porPropietario(Usuario u){
        return repositorio.findByPropietario(u);
    }



}
