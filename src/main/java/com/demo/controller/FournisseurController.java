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

import com.demo.modele.dtos.FournisseurDTO;
import com.demo.prestations_service.FournisseurService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fournisseur")
@RequiredArgsConstructor
public class FournisseurController {
private final FournisseurService service;
@PostMapping
public ResponseEntity<FournisseurDTO>save(@RequestBody FournisseurDTO dto){
	return ResponseEntity.ok(service.save(dto));
}
@GetMapping("/{id}")
public ResponseEntity<FournisseurDTO> findById(@PathVariable long id){
	return ResponseEntity.ok(service.findById(id));
}
@GetMapping
public ResponseEntity<List<FournisseurDTO>> findAll(){
	return ResponseEntity.ok(service.findAll());
}
@DeleteMapping("/{id}")
public void delete(@PathVariable long id) {
	service.delete(id);
}
}
