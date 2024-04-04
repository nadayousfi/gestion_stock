package com.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.modele.dtos.CommandClientDTO;
import com.demo.modele.dtos.LigneCommandClientDTO;
import com.demo.modele.entites.CommandClient;
import com.demo.modele.entites.EtatCommand;
import com.demo.prestations_service.CommandClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/commandClient")
@RequiredArgsConstructor
public class CommandClientController {
private final CommandClientService service;
@PostMapping
public ResponseEntity<CommandClientDTO>save(@RequestBody CommandClientDTO dto){
	return ResponseEntity.ok(service.save(dto));
}
@PatchMapping("/updateEtat/{idCommand}/{etat}")
public ResponseEntity<CommandClientDTO>update (@PathVariable long idCommand,@PathVariable EtatCommand etat){
	return ResponseEntity.ok(service.update(idCommand, etat));
}
@PatchMapping("updateQuantite/{idCommand}/{idLigneCommand}/{quantite}")
public ResponseEntity<CommandClientDTO>updateQuantiteCommand(@PathVariable long idCommand,@PathVariable long idLigneCommand,@PathVariable BigDecimal quantite){
	return ResponseEntity.ok(service.updateQuantiteCommand(idCommand, idLigneCommand, quantite));
}
@PatchMapping("updateClient/{idCommand}/{idClient}")
public ResponseEntity<CommandClientDTO>updateClient(@PathVariable long idCommand,@PathVariable long idClient){
	return ResponseEntity.ok(service.updateClient(idCommand, idClient));
}
@PatchMapping("updateArticle/{idCommand}/{idLigneCommand}")
public ResponseEntity<CommandClientDTO>updateArticle(@PathVariable long idCommand,@PathVariable long idLigneCommand,long idArticle){
	return ResponseEntity.ok(service.updateArticle(idCommand, idLigneCommand, idArticle));
}
@DeleteMapping("article/{id}")
public ResponseEntity<CommandClientDTO> deleteArticle(@PathVariable long idCommand,@PathVariable long idLigneCommand){
	return ResponseEntity.ok(service.deleteArticle(idCommand, idLigneCommand));
}
@GetMapping("findId/{id}")
public ResponseEntity<CommandClientDTO> findById(@PathVariable long id){
	return ResponseEntity.ok(service.findById(id));
}
@GetMapping("findCode/{code}")
public ResponseEntity<CommandClientDTO> findByCode(@PathVariable String code){
	return ResponseEntity.ok(service.findByCode(code));
}
@GetMapping
public ResponseEntity<List<CommandClientDTO>> findAll(){
	return ResponseEntity.ok(service.findAll());
}
@GetMapping("findAllLignes")
public ResponseEntity<List<LigneCommandClientDTO>> findAllLigneCommandLignes(@PathVariable long idCommand){
	return ResponseEntity.ok(service.findAllLignesCommandesClientByCommandClientId(idCommand));
}
@DeleteMapping("/{id}")
public void delete(@PathVariable long id) {
	service.delete(id);
}
}
