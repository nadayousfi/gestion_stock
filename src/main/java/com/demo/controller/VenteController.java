package com.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.modele.dtos.VenteDTO;
import com.demo.prestations_service.VentesService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/vente")
@RestController
@RequiredArgsConstructor
public class VenteController {
private final VentesService service;
@PostMapping
public ResponseEntity<VenteDTO>save(@RequestBody VenteDTO dto){
	return ResponseEntity.ok(service.save(dto));
}
@GetMapping("/{id}")
public ResponseEntity<VenteDTO> findById(@PathVariable long id){
	return ResponseEntity.ok(service.findById(id));
}
@GetMapping("code/{code}")
public ResponseEntity<VenteDTO>findByCode(@PathVariable String code){
	return ResponseEntity.ok(service.findByCode(code));
}
@GetMapping
public ResponseEntity<List<VenteDTO>> findAll(){
	return ResponseEntity.ok(service.findAll());
}
}
