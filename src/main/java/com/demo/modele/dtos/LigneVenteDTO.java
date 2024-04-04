package com.demo.modele.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LigneVenteDTO {
	private BigDecimal quantite;
	private BigDecimal prixunitaire;
	private Integer idEntreprise;
	@JsonIgnoreProperties("lignesVentes")
	private VenteDTO vente;
	@JsonIgnoreProperties("ligneVentes")
	private ArticleDTO article;
}
