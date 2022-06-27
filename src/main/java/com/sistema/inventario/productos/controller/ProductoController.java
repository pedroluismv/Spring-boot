package com.sistema.inventario.productos.controller;

import com.sistema.inventario.categoria.Categoria;
import com.sistema.inventario.categoria.repository.CategoriaRepository;
import com.sistema.inventario.productos.Producto;
import com.sistema.inventario.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping(value = "productos/nuevo")
    public String mostrarformularioProducto(Model modelo) {

        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("producto", new Producto());
        modelo.addAttribute("listaCategorias", listaCategorias);
        return "producto_formulario";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto, HttpServletRequest request) {
        String[] detallesID = request.getParameterValues("detalleID");
        String[] detallesNombres = request.getParameterValues("detallesNombres");
        String[] detallesValores = request.getParameterValues("detallesValores");

        for (int i = 0; i < detallesNombres.length; i++) {
            if (detallesID != null && detallesID.length > 0) {
                producto.setDetalles(Integer.valueOf(detallesID[i]), detallesNombres[i], detallesValores[i]);

            } else {
                producto.anadirDetalles(detallesNombres[i], detallesValores[i]);
            }
        }

        productoRepository.save(producto);
        return "redirect:/";
    }

    @GetMapping(value = "/productos")
    public String listaProductos(Model modelo) {
        List<Producto> listaProductos = productoRepository.findAll();
        modelo.addAttribute("listaProductos", listaProductos);
        return "productos";
    }

    @GetMapping(value = "/productos/editar/{id}")
    public String editarProducto(@PathVariable("id") Integer id, Model modelo) {
        Producto producto = productoRepository.findById(id).get();
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("producto", producto);
        modelo.addAttribute("listaCategorias", listaCategorias);
        return "producto_formulario";
    }

    @GetMapping(value = "/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id, Model modelo) {
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }
}
