package com.sistema.inventario.marca.controller;

import com.sistema.inventario.categoria.Categoria;
import com.sistema.inventario.categoria.repository.CategoriaRepository;
import com.sistema.inventario.marca.Marca;
import com.sistema.inventario.marca.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping(value = "/marcas/nuevo")
    public String mostrarFormularioMarca(Model modelo){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("listaCategorias", listaCategorias);
        modelo.addAttribute("marca", new Marca());
        return  "marca_formulario";
    }

    @PostMapping("/marcas/guardar")
    public String guardarMarca(Marca marca){
        marcaRepository.save(marca);
        return "redirect:/";
    }

    @GetMapping(value = "/marcas")
    public String listaMarcas(Model modelo){
        List<Marca> listaMarcas = marcaRepository.findAll();
        modelo.addAttribute("listaMarcas", listaMarcas);
        return "marcas";
    }

    @GetMapping(value="/marcas/editar/{id}")
    public String editarMarca(@PathVariable("id") Integer id, Model modelo ){
        Marca marca = marcaRepository.findById(id).get();
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("marca", marca);
        modelo.addAttribute("listaCategorias", listaCategorias);
        return "marca_formulario";
    }

}
