package com.demo.depot;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.CommandFournisseur;

public interface CommandFournisseurRepository extends JpaRepository<CommandFournisseur, Long> {
Optional<CommandFournisseur> findByCode(String code);
}
