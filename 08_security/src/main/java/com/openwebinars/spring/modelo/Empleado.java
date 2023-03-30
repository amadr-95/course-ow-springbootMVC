package com.openwebinars.spring.modelo;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Empleado {
	@Min(value = 0, message = "{empleado.id.mayorquecero}")
	private long id;
	@NotEmpty
	private String nombre;
	@Email
	private String email;
	private String telefono;
	private boolean directivo;
	
	public Empleado() { }

	public Empleado(long id, String nombre, String email, String telefono, boolean directivo) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.directivo = directivo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean getDirectivo(){
		return directivo;
	}

	public void setDirectivo(Boolean directivo){
		this.directivo = directivo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Empleado empleado = (Empleado) o;
		return id == empleado.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Empleado{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", email='" + email + '\'' +
				", telefono='" + telefono + '\'' +
				", directivo=" + directivo +
				'}';
	}
}
