package com.project.spring.SecondHandMarket.servicios;

import com.project.spring.SecondHandMarket.modelo.Compra;
import com.project.spring.SecondHandMarket.modelo.Producto;
import com.project.spring.SecondHandMarket.modelo.Usuario;
import com.project.spring.SecondHandMarket.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    ProductoRepository repositorio;

    //metodos CRUD
    public Producto insertar(Producto p){
        return repositorio.save(p);
    }

    public void borrar(long id){
        repositorio.deleteById(id);
    }

    public void borrar(Producto p){
        repositorio.delete(p);
    }

    public Producto editar(Producto p){
        return repositorio.save(p);
    }

    public Producto findById(long id){
        return repositorio.findById(id).orElse(null);
    }

    public List<Producto> findAll(){
        return repositorio.findAll();
    }

    public List<Producto> productosUnPropietario(Usuario u){
        return repositorio.findByPropietario(u);
    }

    public List<Producto> productosUnaCompra(Compra c){
        return repositorio.findByCompra(c);
    }

    public List<Producto> productosSinVender(){
        return repositorio.findByCompraIsNull();
    }

    public List<Producto> buscar(String query){
        return repositorio.findByNombreContainsIgnoreCaseAndCompraIsNull(query);
    }

    public List<Producto> buscarMisProductos(String query, Usuario u){
        return repositorio.findByNombreContainsIgnoreCaseAndPropietario(query, u);
    }

    public List<Producto> buscarPorId(List<Long> ids){
        return repositorio.findAllById(ids);
    }

}
