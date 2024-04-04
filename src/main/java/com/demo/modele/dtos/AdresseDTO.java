package com.demo.modele.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdresseDTO {
	private String adresse1;
	private String adresse2;
	private String ville;
	private String codePostal;
	private String pays;
}
