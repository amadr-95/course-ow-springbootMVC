package com.project.spring.SecondHandMarket.repositorios;

import com.project.spring.SecondHandMarket.modelo.Compra;
import com.project.spring.SecondHandMarket.modelo.Producto;
import com.project.spring.SecondHandMarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    //buscar todos los productos de un determinado usuario
    List<Producto> findByPropietario(Usuario propietario);
    //buscar todos los productos de una determinada compra
    List<Producto> findByCompra(Compra compra);
    //buscar todos los productos que aun no se han comprado (compra es nula)
    List<Producto> findByCompraIsNull();
    //buscar todos los productos no comprados cuyo nombre contiene una cadena de caracteres
    List<Producto> findByNombreContainsIgnoreCaseAndCompraIsNull(String nombre);
    //buscar todos los productos de un usuario cuyo nombre contiene una cadena de caracteres
    List<Producto> findByNombreContainsIgnoreCaseAndPropietario(String nombre, Usuario propietario);
}
