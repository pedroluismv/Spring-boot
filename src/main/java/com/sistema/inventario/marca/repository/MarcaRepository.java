package com.sistema.inventario.marca.repository;

import com.sistema.inventario.marca.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
