package com.demo.prestations_service;

import java.math.BigDecimal;
import java.util.List;

import com.demo.modele.dtos.CommandFournisseurDto;
import com.demo.modele.dtos.LigneCommandFournisseurDTO;
import com.demo.modele.entites.EtatCommand;

public interface CommandFournisseurService {
public CommandFournisseurDto save(CommandFournisseurDto commandFournisseurDTO);
public CommandFournisseurDto updateEtatComman(long idCommand,EtatCommand etatCommand);
public CommandFournisseurDto updateQuantiteCommand(long idCommand,long idLigneCommand,BigDecimal quantite);
public CommandFournisseurDto updateFournisseur(long idCommand,long idFournisseur);
public CommandFournisseurDto updateArticle(long idCommand,long  idLigneCommand,long idArticle);
public CommandFournisseurDto deleteArticle(long idCommand,long idLigneCommand,long idArticle);
public CommandFournisseurDto findById(long id);
public CommandFournisseurDto findByCode(String code);
public List<CommandFournisseurDto> findAll();
public List<LigneCommandFournisseurDTO> findAllLigneCommandsFournisseurByCommandFournisseurId(long idCommand);
public void delete(long id);
}
