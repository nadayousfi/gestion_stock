package com.demo.modele.dtos;

import java.time.Instant;
import java.util.List;

import com.demo.modele.entites.Adresse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
	private String nom;
	private String prenom;
	private String email;
	private Instant dateNaissance;
	private String motDePasse;
	private Adresse adresse;
	private String photo;
	@JsonIgnoreProperties("utilisateur")
	private EntrepriseDTO entreprise;
	@JsonIgnoreProperties("idUtilisateur")
	private List<RoleDTO> roles;
	
}
