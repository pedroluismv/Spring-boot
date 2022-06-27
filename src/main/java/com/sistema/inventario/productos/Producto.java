package com.sistema.inventario.productos;

import com.sistema.inventario.categoria.Categoria;
import com.sistema.inventario.productos.detalles.ProductoDetalles;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String nombre;

    private float precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProductoDetalles> detalles = new ArrayList<>();


    public Producto() {
    }

    public Producto(Integer id, String nombre, float precio, Categoria categoria) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(String nombre, float precio, Categoria categoria) {
        super();
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(String nombre) {
        super();
        this.nombre = nombre;
    }

    public void anadirDetalles(String nombre, String valor) {
        this.detalles.add(new ProductoDetalles(nombre, valor, this));
    }

    public void setDetalles(Integer id, String nombre, String valor){
        this.detalles.add(new ProductoDetalles(id, nombre, valor, this));
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public List<ProductoDetalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ProductoDetalles> detalles) {
        this.detalles = detalles;
    }
}
