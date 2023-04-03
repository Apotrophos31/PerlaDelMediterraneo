package com.example.perladelmediterraneo.repositories;

import com.example.perladelmediterraneo.model.Prodotti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottiRepository extends JpaRepository<Prodotti, Integer> {
}
