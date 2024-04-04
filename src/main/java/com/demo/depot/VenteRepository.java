package com.demo.depot;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.Ventes;

public interface VenteRepository extends JpaRepository<Ventes, Long> {
Optional<Ventes> findByCode(String code);
}
