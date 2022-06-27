package com.sistema.inventario.usuarios.repository;

import com.sistema.inventario.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
