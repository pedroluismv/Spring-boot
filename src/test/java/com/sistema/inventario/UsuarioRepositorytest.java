package com.sistema.inventario;

import com.sistema.inventario.roles.Rol;
import com.sistema.inventario.usuarios.Usuario;
import com.sistema.inventario.usuarios.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UsuarioRepositorytest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCrearRoles() {
        Rol rolAdmin = new Rol("Administrador");
        Rol rolEditor = new Rol("Editor");
        Rol rolVisitante = new Rol("Visitante");

        testEntityManager.persist(rolAdmin);
        testEntityManager.persist(rolEditor);
        testEntityManager.persist(rolVisitante);
    }

    @Test
    public void testCrearUsuarioConRol() {
        Rol rolAdmin = testEntityManager.find(Rol.class, 1);
        Usuario usuario1 = new Usuario("pedro@gmail.com", "123456789");
        usuario1.añadirRol(rolAdmin);
        usuarioRepository.save(usuario1);
    }

    @Test
    public void testCrearUsuarioConDosRoles() {
        Rol rolVisitante = testEntityManager.find(Rol.class, 3);
        Rol rolEditor = testEntityManager.find(Rol.class, 2);
        Usuario usuario1 = new Usuario("luis@gmail.com", "123456789");
        usuario1.añadirRol(rolVisitante);
        usuario1.añadirRol(rolEditor);
        usuarioRepository.save(usuario1);
    }

    @Test
    public void testAsignarRolUsuario() {
        Rol rolVisitante = testEntityManager.find(Rol.class, 3);
        Usuario usuario1 = usuarioRepository.findById(1).get();

        usuario1.añadirRol(rolVisitante);
    }

    @Test
    public void eliminarRolUsuario(){
        Usuario usuario1 = usuarioRepository.findById(1).get();
        Rol rolVisitante = testEntityManager.find(Rol.class, 3);
        usuario1.eliminarRol(rolVisitante);
    }

    @Test
    public void testCrearUsuarioConNuevoRol() {
        Rol rolVendedor = new Rol("Vendedor");
        Usuario usuario1 = new Usuario("maria@gmail.com", "123456789");
        usuario1.añadirRol(rolVendedor);
        usuarioRepository.save(usuario1);
    }

}

