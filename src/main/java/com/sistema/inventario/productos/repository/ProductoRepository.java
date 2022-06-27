package com.sistema.inventario.productos.repository;

import com.sistema.inventario.productos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
