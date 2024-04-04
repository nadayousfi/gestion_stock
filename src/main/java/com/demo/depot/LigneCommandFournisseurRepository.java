package com.demo.depot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.dtos.LigneCommandFournisseurDTO;
import com.demo.modele.entites.LigneCommandFournisseur;

public interface LigneCommandFournisseurRepository extends JpaRepository<LigneCommandFournisseur, Long> {
List<LigneCommandFournisseur> findAllByArticleId(long id);
List<LigneCommandFournisseur> findAllByCommandFournisseurId(long id);
}
