package com.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.modele.dtos.CategorieDTO;
import com.demo.modele.entites.Category;
import com.demo.prestations_service.CategorieService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping("category")
public class CategoryController {
private final CategorieService service;
@PostMapping
public ResponseEntity<CategorieDTO> save(@Valid @RequestBody CategorieDTO dto){
	return ResponseEntity.ok(service.save(dto));
}
@GetMapping("/{id}")
public ResponseEntity<CategorieDTO> findById(@PathVariable long id){
	return ResponseEntity.ok(service.findById(id));
}

@GetMapping
public ResponseEntity<List<CategorieDTO>> getall(){
	return ResponseEntity.ok(service.findAll());
}
@GetMapping("/code/{id}")
public ResponseEntity<CategorieDTO> findByCode(@PathVariable String code){
	return ResponseEntity.ok(service.findByCode(code));
}
@DeleteMapping("/{id}")
public void delete(@PathVariable long id) {
	service.deleteById(id);
}
}
