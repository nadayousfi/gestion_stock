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

import com.demo.modele.dtos.ArticleDTO;
import com.demo.modele.dtos.LigneCommandClientDTO;
import com.demo.modele.dtos.LigneCommandFournisseurDTO;
import com.demo.modele.dtos.LigneVenteDTO;
import com.demo.prestations_service.ArticleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
private final ArticleService service;
@GetMapping("/{id}")
public ResponseEntity<ArticleDTO> getArticle(@PathVariable long id){
	return ResponseEntity.ok(service.findById(id));
}

@GetMapping
public ResponseEntity<List<ArticleDTO>> getAllArticle(){
	return ResponseEntity.ok(service.findall());
}
@PostMapping
public ResponseEntity<ArticleDTO> addOne(@Valid @RequestBody ArticleDTO articleDTO){
	return ResponseEntity.ok( service.save(articleDTO));
}
@GetMapping("/code/{code}")
public ResponseEntity<ArticleDTO> findByCodeArticle(@PathVariable String  code)
{
	return ResponseEntity.ok(service.findByCodeArticle(code));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable long id) {
	service.deleteById(id);
}
@GetMapping("/historiqueVente/{idArticle}")
public ResponseEntity<List<LigneVenteDTO>> findHisoriqueVente (@PathVariable long idArticle){
	return ResponseEntity.ok(service.findHistoriqueVentes(idArticle));
}
@GetMapping("/historiqueCommandeClient/{id}")
public ResponseEntity<List<LigneCommandClientDTO>> findHistoriqueCommandClient(@PathVariable long id){
	return ResponseEntity.ok(service.findHistoriqueCommandClient(id));
}
@GetMapping("/commandFournisseur/{id}")
public ResponseEntity<List<LigneCommandFournisseurDTO>> findHistoriqueCommandFournisseur(@PathVariable long id){
	return ResponseEntity.ok(service.findHistoriqueCommandeFournisseur(id));
}
@GetMapping("/category/{id}")
public ResponseEntity<List<ArticleDTO>> findAllArticleByCategory(@PathVariable long id){
	return ResponseEntity.ok(service.findAllArticleByIdCategory(id));
}
}
