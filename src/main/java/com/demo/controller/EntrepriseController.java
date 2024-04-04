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

import com.demo.modele.dtos.EntrepriseDTO;
import com.demo.prestations_service.EntrepriseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/entreprise")
@RequiredArgsConstructor
public class EntrepriseController {
private final EntrepriseService service;
@PostMapping
public ResponseEntity<EntrepriseDTO> save(@RequestBody EntrepriseDTO dto){
	return  ResponseEntity.ok(service.save(dto));
}
@GetMapping("/{id}")
public ResponseEntity<EntrepriseDTO>findById(@PathVariable long id){
	return ResponseEntity.ok(service.findById(id));
}
@GetMapping
ResponseEntity<List<EntrepriseDTO>> findAll(){
	return ResponseEntity.ok(service.findAll());
}
@DeleteMapping("/{id}")
public void delete(@PathVariable long id) {
	service.delete(id);
}
}
