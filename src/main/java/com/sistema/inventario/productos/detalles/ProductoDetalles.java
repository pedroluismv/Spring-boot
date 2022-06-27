package com.sistema.inventario.productos.detalles;


import com.sistema.inventario.productos.Producto;

import javax.persistence.*;

@Entity
@Table(name = "producto_detalles")
public class ProductoDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String nombre;

    @Column(length = 45, nullable = false, unique = true)
    private String valor;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public ProductoDetalles() {
    }

    public ProductoDetalles(Integer id, String nombre, String valor, Producto producto) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
    }

    public ProductoDetalles(String nombre, String valor, Producto producto) {
        super();
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return  nombre +  " - " + valor;
    }
}
