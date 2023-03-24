package com.openwebinars.spring.modelo;


import java.util.Objects;

public class Empleado {
	
	private long id;
	private String nombre;
	private String email;
	private String telefono;
	
	public Empleado() { }

	public Empleado(long id, String nombre, String email, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
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
				'}';
	}
}
