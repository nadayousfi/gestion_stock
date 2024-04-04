package com.demo.modele.dtos;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
	private String codeArticle;
	private String designation;
	private BigDecimal prixUnitaire;
	private String photo;
	private Integer idEntreprise;
	@JsonIgnoreProperties("articles")
	private CategorieDTO category;
	@JsonIgnoreProperties("article")
	private List<LigneVenteDTO> ligneVentes;
	@JsonIgnoreProperties("article")
	private List<LigneCommandClientDTO> ligneCommandClients;
	@JsonIgnoreProperties("article")
	private List<LigneCommandFournisseurDTO> ligneCommandFournisseur;
	@JsonIgnoreProperties("article")
	private List<MvstckDTO> mvStcs;
}
