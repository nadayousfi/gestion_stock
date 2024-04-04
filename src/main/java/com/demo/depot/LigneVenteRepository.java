package com.demo.depot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.LigneVente;

public interface LigneVenteRepository extends JpaRepository<LigneVente, Long> {
List<LigneVente>findAllByArticleId(long id);
}
