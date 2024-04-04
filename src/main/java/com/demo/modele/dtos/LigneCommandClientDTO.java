package com.demo.modele.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LigneCommandClientDTO {
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
	private Integer idEntreprise;
	@JsonIgnoreProperties("ligneCommandClients")
	private ArticleDTO article;
	@JsonIgnoreProperties("ligneCommandClients")
	private CommandClientDTO commandClient;
}
