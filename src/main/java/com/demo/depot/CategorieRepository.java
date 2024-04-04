package com.demo.depot;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.Category;

public interface CategorieRepository extends JpaRepository<Category, Long> {
	
	Optional<Category> findByCode(String code);
}
