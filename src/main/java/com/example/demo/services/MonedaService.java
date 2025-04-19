package com.example.demo.services;

import com.example.demo.models.Moneda;

import java.util.List;
import java.util.Optional;

public interface MonedaService {

    List<Moneda> listarMonedas();

    Optional<Moneda> obtenerMonedaPorId(Long id);

    Moneda guardarMoneda(Moneda moneda);

    Moneda actualizarMoneda(Long id, Moneda monedaActualizada);

    void eliminarMoneda(Long id);
}
