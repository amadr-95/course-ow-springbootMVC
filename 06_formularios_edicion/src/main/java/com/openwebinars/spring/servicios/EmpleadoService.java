package com.openwebinars.spring.servicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.openwebinars.spring.modelo.Empleado;

@Service
public class EmpleadoService {
	private List<Empleado> repositorio = new ArrayList<>();
	
	public Empleado add(Empleado e) {
		repositorio.add(e);
		return e;
	}
	
	public List<Empleado> findAll() {
		return repositorio;
	}

	//metodo para buscar al empleado por ID y rescatar sus datos
	public Empleado buscarID(Long id){
		Empleado empleado = null;
		for (Empleado elem: repositorio){
			if(id == elem.getId()){
				empleado = elem;
				break;
			}
		}
		return empleado;
	}
	//metodo para editar los datos del usuario
	public Empleado edit(Empleado empleado){
		int pos;
		boolean encontrado = false;
		for (Empleado elem: repositorio){
			if(empleado.getId() == elem.getId()){
				encontrado= true;
				pos = repositorio.indexOf(elem); //obtengo el indice
				repositorio.remove(elem); //lo borro
				repositorio.add(pos, empleado); //añado los cambios en ese indice
				break;
			}
		}
		//si no lo encuentra, lo añade
		if(!encontrado)
			repositorio.add(empleado);
		return empleado;
	}
	
	@PostConstruct
	public void init() {
		repositorio.addAll(
				Arrays.asList(new Empleado(1,"Antonio García", "antonio.garcia@openwebinars.net", "954000000", true),
						new Empleado(2,"María López", "maria.lopez@openwebinars.net", "954000000", false),
						new Empleado(3,"Ángel Antúnez", "angel.antunez@openwebinars.net", "954000000", false))
				);
	}

}
