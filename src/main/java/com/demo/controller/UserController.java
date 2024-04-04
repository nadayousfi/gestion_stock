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

import com.demo.modele.dtos.UserDTO;
import com.demo.prestations_service.UtilisateurService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
private final UtilisateurService service;
@PostMapping
public ResponseEntity<UserDTO>save(@RequestBody UserDTO dto){
	return ResponseEntity.ok(service.save(dto));
}
@GetMapping("/{id}")
public ResponseEntity<UserDTO> findById(@PathVariable long id){
	return ResponseEntity.ok(service.findById(id));
}
@GetMapping
public ResponseEntity<List<UserDTO>> findAll(){
	return ResponseEntity.ok(service.findAll());
}
@DeleteMapping("/{id}")
public void delete(@PathVariable long id ) {
	service.delete(id);
}
@GetMapping("email/{email}")
public ResponseEntity<UserDTO> findEmail(@PathVariable String email){
	return ResponseEntity.ok(service.findByEmail(email));
}

}
