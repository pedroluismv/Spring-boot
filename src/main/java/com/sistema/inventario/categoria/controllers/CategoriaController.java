package com.sistema.inventario.categoria.controllers;

import com.sistema.inventario.categoria.Categoria;
import com.sistema.inventario.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaRepository repositorio;

    @GetMapping(value= "/categorias")
    public String listarCategorias(Model modelo){
        List<Categoria> listaCategorias = repositorio.findAll();
        modelo.addAttribute("listaCategorias", listaCategorias);
        return "categorias";
    }


    @GetMapping(value="/categorias/nuevo")
    public String mostrarFormulariocategoria(Model modelo){
        modelo.addAttribute("categoria", new Categoria());
        return "categoria_formulario";
    }


    @PostMapping(value="/categorias/guardar")
    public String guardarCategoría(Categoria categoria){
        repositorio.save(categoria);
        return "redirect:/categorias";
    }
}
