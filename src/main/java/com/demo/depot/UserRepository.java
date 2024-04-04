package com.demo.depot;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.Utilisateur;
import java.util.List;


public interface UserRepository extends JpaRepository<Utilisateur, Long> {
Optional<Utilisateur> findByEmail(String email);
}
