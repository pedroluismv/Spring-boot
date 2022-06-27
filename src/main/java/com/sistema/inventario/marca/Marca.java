package com.sistema.inventario.marca;

import com.sistema.inventario.categoria.Categoria;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String nombre;

    @OneToMany
    @JoinColumn(name = "marca_id")
    private List<Categoria> categorias = new ArrayList<>();


    public Marca(Integer id, String nombre, List<Categoria> categorias) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.categorias = categorias;
    }

    public Marca(Integer id) {
        super();
        this.id = id;
    }

    public Marca(String nombre, List<Categoria> categorias) {
        super();
        this.nombre = nombre;
        this.categorias = categorias;
    }

    public Marca() {
        super();
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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}
