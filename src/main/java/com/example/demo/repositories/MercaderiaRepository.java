package com.example.demo.repositories;

import com.example.demo.models.Mercaderia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercaderiaRepository extends JpaRepository<Mercaderia, Long> {
}

