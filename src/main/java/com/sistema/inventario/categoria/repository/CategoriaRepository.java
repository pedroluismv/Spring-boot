package com.sistema.inventario.categoria.repository;


import com.sistema.inventario.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
