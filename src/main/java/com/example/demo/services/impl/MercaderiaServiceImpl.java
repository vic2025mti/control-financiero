package com.example.demo.services.impl;

import com.example.demo.models.Mercaderia;
import com.example.demo.repositories.MercaderiaRepository;
import com.example.demo.services.MercaderiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercaderiaServiceImpl implements MercaderiaService {

    @Autowired
    private MercaderiaRepository mercaderiaRepository;

    @Override
    public List<Mercaderia> findAll() {
        return mercaderiaRepository.findAll();
    }

    @Override
    public Optional<Mercaderia> findById(Long id) {
        return mercaderiaRepository.findById(id);
    }

    @Override
    public Mercaderia save(Mercaderia mercaderia) {
        return mercaderiaRepository.save(mercaderia);
    }

    @Override
    public Mercaderia update(Long id, Mercaderia mercaderia) {
        Optional<Mercaderia> existing = mercaderiaRepository.findById(id);
        if (existing.isPresent()) {
            mercaderia.setIdMercaderia(id); // Suponiendo que tu campo PK se llama idMercaderia
            return mercaderiaRepository.save(mercaderia);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        mercaderiaRepository.deleteById(id);
    }
}

