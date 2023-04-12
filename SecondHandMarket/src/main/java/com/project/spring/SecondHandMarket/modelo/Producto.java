package com.project.spring.SecondHandMarket.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Producto {
    @Id @GeneratedValue
    private long id;
    private String nombre;
    private double precio;
    private String imagen;

    @ManyToOne
    private Usuario propietario;

    @ManyToOne
    private Compra compra;

    public Producto(){
    }

    public Producto(String nombre, double precio, String imagen, Usuario propietario) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.propietario = propietario;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return getId() == producto.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", propietario=" + propietario +
                ", compra=" + compra +
                '}';
    }
}
