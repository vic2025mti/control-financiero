package com.example.demo.services.impl;

import com.example.demo.models.Moneda;
import com.example.demo.repositories.MonedaRepository;
import com.example.demo.services.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonedaServiceImpl implements MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    public List<Moneda> listarMonedas() {
        return monedaRepository.findAll();
    }

    @Override
    public Optional<Moneda> obtenerMonedaPorId(Long id) {
        return monedaRepository.findById(id);
    }

    @Override
    public Moneda guardarMoneda(Moneda moneda) {
        return monedaRepository.save(moneda);
    }

    @Override
    public Moneda actualizarMoneda(Long id, Moneda monedaActualizada) {
        return monedaRepository.findById(id).map(moneda -> {
            moneda.setDescripcion(monedaActualizada.getDescripcion());
            moneda.setSimbolo(monedaActualizada.getSimbolo());
            return monedaRepository.save(moneda);
        }).orElse(null);
    }

    @Override
    public void eliminarMoneda(Long id) {
        monedaRepository.deleteById(id);
    }
}
