package com.example.perladelmediterraneo.repositories;

import com.example.perladelmediterraneo.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {
}
