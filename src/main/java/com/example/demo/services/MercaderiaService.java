package com.example.demo.services;

import com.example.demo.models.Mercaderia;

import java.util.List;
import java.util.Optional;

public interface MercaderiaService {
    List<Mercaderia> findAll();
    Optional<Mercaderia> findById(Long id);
    Mercaderia save(Mercaderia mercaderia);
    Mercaderia update(Long id, Mercaderia mercaderia);
    void delete(Long id);
}
