package com.example.demo.services;


import com.example.demo.models.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {

    List<Marca> listarMarcas();

    Optional<Marca> obtenerMarcaPorId(Long id);

    Marca guardarMarca(Marca marca);

    Marca actualizarMarca(Long id, Marca marcaActualizada);

    void eliminarMarca(Long id);
}
