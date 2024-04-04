package com.demo.depot;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}
