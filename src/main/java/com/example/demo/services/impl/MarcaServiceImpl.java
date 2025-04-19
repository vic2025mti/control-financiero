package com.example.demo.services.impl;

import com.example.demo.models.Marca;
import com.example.demo.repositories.MarcaRepository;
import com.example.demo.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<Marca> obtenerMarcaPorId(Long id) {
        return marcaRepository.findById(id);
    }

    @Override
    public Marca guardarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca actualizarMarca(Long id, Marca marcaActualizada) {
        return marcaRepository.findById(id).map(marca -> {
            marca.setNombre(marcaActualizada.getNombre());
            return marcaRepository.save(marca);
        }).orElse(null);
    }

    @Override
    public void eliminarMarca(Long id) {
        marcaRepository.deleteById(id);
    }
}
