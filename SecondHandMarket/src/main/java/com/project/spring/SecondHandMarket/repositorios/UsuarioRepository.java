package com.project.spring.SecondHandMarket.repositorios;

import com.project.spring.SecondHandMarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    //buscar un usuario por su email
    Usuario findFirstByEmail(String email);
}
