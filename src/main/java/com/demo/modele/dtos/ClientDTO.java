package com.demo.modele.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClientDTO {
	private String nom;
	private String prenom;
	private AdresseDTO adresse;
	private String photo;
	private String mail;
	private String numTel;
	private Integer idEntreprise;
	 @JsonIgnoreProperties("client")
	private List<CommandClientDTO> commandeClients;
}
