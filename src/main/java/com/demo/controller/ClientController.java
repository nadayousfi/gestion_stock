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

import com.demo.modele.dtos.ClientDTO;
import com.demo.prestations_service.ClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
public class ClientController {
private final ClientService service;
@PostMapping
public ResponseEntity<ClientDTO> addOne(@RequestBody ClientDTO dto){
	return ResponseEntity.ok(service.save(dto));
}
@GetMapping("/{id}")
public ResponseEntity<ClientDTO> findById(@PathVariable long id){
	return ResponseEntity.ok(service.findById(id));
}
@GetMapping
public ResponseEntity<List<ClientDTO>> getAll(){
	return ResponseEntity.ok(service.findAll());
}
@DeleteMapping
public void delete(@PathVariable long id){
	service.delete(id);
}
}
