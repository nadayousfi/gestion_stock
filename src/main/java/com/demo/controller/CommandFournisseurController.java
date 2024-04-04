package com.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.modele.dtos.CommandFournisseurDto;
import com.demo.modele.dtos.LigneCommandFournisseurDTO;
import com.demo.modele.entites.EtatCommand;
import com.demo.prestations_service.CommandFournisseurService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/commandFourinsseur")
public class CommandFournisseurController {
private final CommandFournisseurService service;
@PostMapping
public ResponseEntity<CommandFournisseurDto>addOne(@RequestBody CommandFournisseurDto dto){
	return ResponseEntity.ok(service.save(dto));
}
@GetMapping("/{id}")
public ResponseEntity<CommandFournisseurDto> findById(@PathVariable long id){
	return ResponseEntity.ok(service.findById(id));
}
@GetMapping("/code/{code}")
public ResponseEntity<CommandFournisseurDto> findByCode(@PathVariable String code){
	return ResponseEntity.ok(service.findByCode(code));
}
@GetMapping
public ResponseEntity<List<CommandFournisseurDto>> findAll(){
	return ResponseEntity.ok(service.findAll());
}
@PatchMapping("/updateEtatCommand/{idCommand}/{etat}")
public ResponseEntity<CommandFournisseurDto> updateEtatCommand(@PathVariable long idCommand,@PathVariable EtatCommand etat){
	return ResponseEntity.ok(service.updateEtatComman(idCommand, etat));
}
@PatchMapping("updateQuantiteCommand/{idCommand}/{idLigneCommand}/{quantite}")
public ResponseEntity<CommandFournisseurDto> updateQuantiteCommand(@PathVariable long idCommand,@PathVariable long idLigneCommand,@PathVariable BigDecimal quantite){
	return ResponseEntity.ok(service.updateQuantiteCommand(idCommand, idLigneCommand, quantite));
}
@PatchMapping("updateFournisseur/{idCommand}/{idFournisseur}")
public ResponseEntity<CommandFournisseurDto> updateFourinsseur(@PathVariable long idCommand,@PathVariable long idFournisseur){
	return ResponseEntity.ok(service.updateFournisseur(idCommand, idFournisseur));
}
@PatchMapping("updateArticle/{idCommand}/{idLigneCommand}/{idArticle}")
public ResponseEntity<CommandFournisseurDto> updateArticle(@PathVariable long idCommand,@PathVariable long idLigneCommand,@PathVariable long idArticle){
	return ResponseEntity.ok(service.updateArticle(idCommand, idLigneCommand, idArticle));
}
@GetMapping("ligneCommandFournisseur/{idCommand}")
public ResponseEntity<List<LigneCommandFournisseurDTO>> findAllLigneCommandFournisseurByCommandFournisseur(@PathVariable long idCommand){
	return ResponseEntity.ok(service.findAllLigneCommandsFournisseurByCommandFournisseurId(idCommand));
}
@DeleteMapping("{idCommand}/{idLigneCommand}/{idArticle}")
public ResponseEntity<CommandFournisseurDto> deleteArticle(@PathVariable long idCommand,@PathVariable long idLigneCommand,@PathVariable long idArticle){
	return ResponseEntity.ok(service.deleteArticle(idCommand, idLigneCommand, idArticle));
}
@DeleteMapping
public void delete(@PathVariable long id) {
	service.delete(id);
}
}
