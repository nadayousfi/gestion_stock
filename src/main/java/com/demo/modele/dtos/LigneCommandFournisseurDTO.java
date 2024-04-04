package com.demo.modele.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LigneCommandFournisseurDTO {
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
	private Integer idEntreprise;
	private ArticleDTO article;
	private CommandClientDTO commandClient;
}
