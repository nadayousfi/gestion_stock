package com.demo.modele.dtos;

import java.util.List;

import com.demo.modele.entites.Adresse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FournisseurDTO {
	private String nom;
	private String prenom;
	private Adresse adresse;
	private String photo;
	private String mail;
	private String numTel;
	private Integer idEntreprise;
	private List<CommandFournisseurDto> commandFournisseur;
}
