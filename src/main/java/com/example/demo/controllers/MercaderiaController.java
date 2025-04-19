package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Mercaderia;
import com.example.demo.services.MarcaService;
import com.example.demo.services.MercaderiaService;

@Controller
@RequestMapping("/mercaderias")
public class MercaderiaController {

    @Autowired
    private MercaderiaService mercaderiaService;

    @Autowired
    private MarcaService marcaService;

    // Mostrar todas las mercaderías
    @GetMapping
    public String listarMercaderias(Model model) {
        List<Mercaderia> lista = mercaderiaService.findAll();
        model.addAttribute("mercaderias", lista);
        return "mercaderias/lista"; // src/main/resources/templates/mercaderias/lista.html
    }

    // Mostrar formulario de creación
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("mercaderia", new Mercaderia());
        model.addAttribute("marcas", marcaService.listarMarcas());
        return "mercaderias/formulario"; // src/main/resources/templates/mercaderias/formulario.html
    }

    // Guardar una nueva mercadería
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("mercaderia") Mercaderia mercaderia) {
        mercaderiaService.save(mercaderia);
        return "redirect:/mercaderias";
    }

    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Mercaderia mercaderia = mercaderiaService.findById(id).orElse(null);
        if (mercaderia == null) {
            return "redirect:/mercaderias";
        }
        model.addAttribute("mercaderia", mercaderia);
        model.addAttribute("marcas", marcaService.listarMarcas());
        return "mercaderias/formulario";
    }

    // Eliminar mercadería
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        mercaderiaService.delete(id);
        return "redirect:/mercaderias";
    }
}


