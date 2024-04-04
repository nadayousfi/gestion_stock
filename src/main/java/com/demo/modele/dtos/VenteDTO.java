package com.demo.modele.dtos;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteDTO {
	private String code;
	private Instant dateVente;
	private String commentaire;
	private Integer idEntrepriqe;
	@JsonIgnoreProperties("vente")
	private List<LigneVenteDTO> lignesVentes;
}
