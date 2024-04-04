package com.demo.modele.dtos;

import java.time.Instant;
import java.util.List;

import com.demo.modele.entites.Client;
import com.demo.modele.entites.EtatCommand;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CommandClientDTO {
	private String code;
	private Instant dateCommande;
	private EtatCommand etatCommand;
	private Integer idEntreprise;
	@JsonIgnoreProperties("commandeClients")
	private ClientDTO client;
	@JsonIgnoreProperties("commandClient")
	private List<LigneCommandClientDTO> ligneCommandClients;
	public Boolean isCommandLivree() {
		return EtatCommand.LIVREE.equals(etatCommand);
	}
}
