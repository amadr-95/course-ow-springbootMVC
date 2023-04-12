package com.project.spring.SecondHandMarket.modelo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.Email;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
    @Id @GeneratedValue
    private long id;
    private String nombre;
    private String apellidos;
    private String avatar;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Email
    private String email;
    private String password;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String avatar, String email, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return getId() == usuario.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
