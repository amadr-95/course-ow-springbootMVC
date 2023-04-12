package com.project.spring.SecondHandMarket.repositorios;

import com.project.spring.SecondHandMarket.modelo.Compra;
import com.project.spring.SecondHandMarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    //Buscar las compras de un determinado usuario
    List<Compra> findByPropietario(Usuario propietario);
}
