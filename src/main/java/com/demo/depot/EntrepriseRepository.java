package com.demo.depot;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
