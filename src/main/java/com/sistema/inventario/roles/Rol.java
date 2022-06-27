package com.sistema.inventario.roles;

import javax.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String nombre;

    public Rol() {
    }

    public Rol(Integer id) {
        super();
        this.id = id;
    }

    public Rol(Integer id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public Rol(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
