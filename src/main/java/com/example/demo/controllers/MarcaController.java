package com.example.demo.controllers;

import com.example.demo.models.Marca;
import com.example.demo.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    // Mostrar todas las marcas en una página HTML
    @GetMapping
    public String listar(Model model) {
        List<Marca> marcas = marcaService.listarMarcas();
        model.addAttribute("marcas", marcas);
        return "marcas/listar";  // Busca templates/marcas/listar.html
    }

    // Mostrar formulario para crear una nueva marca
    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("marca", new Marca());
        return "marcas/formulario";  // Busca templates/marcas/formulario.html
    }

    // Guardar una nueva marca desde el formulario
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Marca marca) {
        marcaService.guardarMarca(marca);
        return "redirect:/marcas";  // Redirige a la lista después de guardar
    }

    // Mostrar formulario para editar una marca
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Marca marca = marcaService.obtenerMarcaPorId(id).orElse(null);
        if (marca != null) {
            model.addAttribute("marca", marca);
            return "marcas/formulario";  // Reutiliza el mismo formulario para editar
        } else {
            return "redirect:/marcas";  // Si no existe, vuelve a la lista
        }
    }

    // Eliminar una marca
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        marcaService.eliminarMarca(id);
        return "redirect:/marcas";
    }
}
