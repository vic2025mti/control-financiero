package com.example.demo.controllers;
import com.example.demo.models.Moneda;
import com.example.demo.services.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/monedas")
public class MonedaController {

    @Autowired
    private MonedaService monedaService;

    @GetMapping
    public List<Moneda> listar() {
        return monedaService.listarMonedas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moneda> obtenerPorId(@PathVariable Long id) {
        return monedaService.obtenerMonedaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Moneda crear(@RequestBody Moneda moneda) {
        return monedaService.guardarMoneda(moneda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Moneda> actualizar(@PathVariable Long id, @RequestBody Moneda moneda) {
        Moneda actualizada = monedaService.actualizarMoneda(id, moneda);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        monedaService.eliminarMoneda(id);
        return ResponseEntity.noContent().build();
    }
}
