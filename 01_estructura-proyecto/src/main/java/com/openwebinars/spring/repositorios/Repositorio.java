package com.openwebinars.spring.repositorios;

import com.openwebinars.spring.entidades.Entidad;
import org.springframework.data.repository.CrudRepository;

//La notación de @Repository no es necesaria si extendemos la interfaz
//CRUD -> CREATE, READ, UPDATE, DELETE
public interface Repositorio extends CrudRepository<Entidad, Long> {
}
