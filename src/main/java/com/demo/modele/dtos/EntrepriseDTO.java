package com.demo.modele.dtos;

import java.util.List;

import com.demo.modele.entites.Adresse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EntrepriseDTO {
	private String nom;
	private String description;
	private Adresse adresse;
	private String codeFiscal;
	private String photo;
	private String email;
	private String numTel;
	private String siteWeb;
	@JsonIgnoreProperties("entreprise")
	private List<UserDTO> utilisateur;
}
