package com.demo.modele.dtos;

import java.time.Instant;
import java.util.List;

import com.demo.modele.entites.EtatCommand;
import com.demo.modele.entites.Fournisseur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CommandFournisseurDto {
	private String code;
	private Instant dateCommand;
	private EtatCommand etatCommmand;
	private Integer idEntreprise;
	private FournisseurDTO fournisseur;
	private List<LigneCommandFournisseurDTO> ligneCommandFournisseur;
	public boolean isCommandLivree() {
		return EtatCommand.LIVREE.equals(etatCommmand);
	}
}
