package com.demo.prestations_service;

import java.math.BigDecimal;
import java.util.List;

import com.demo.modele.dtos.CommandClientDTO;
import com.demo.modele.dtos.LigneCommandClientDTO;
import com.demo.modele.entites.CommandClient;
import com.demo.modele.entites.EtatCommand;

public interface CommandClientService {
public CommandClientDTO save(CommandClientDTO dto);
public CommandClientDTO update(long idCommande,EtatCommand etat);
public CommandClientDTO updateQuantiteCommand(long idCommande,long idLigneCommand,BigDecimal quantite);
public CommandClientDTO updateClient(long idCommand,long idClient);
public CommandClientDTO updateArticle (long idCommand,long idLigneCommand,long idArticle);
public CommandClientDTO deleteArticle(long idCommand,long idLigneCommand);
public CommandClientDTO findById(long id);
public CommandClientDTO findByCode(String code);
public List<CommandClientDTO> findAll();
public List<LigneCommandClientDTO> findAllLignesCommandesClientByCommandClientId(long idCommand);
public void delete(long id);
}
