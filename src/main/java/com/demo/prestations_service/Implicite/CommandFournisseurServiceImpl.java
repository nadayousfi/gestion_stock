package com.demo.prestations_service.Implicite;

import java.awt.dnd.InvalidDnDOperationException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.depot.ArticleRepository;
import com.demo.depot.CommandFournisseurRepository;
import com.demo.depot.FournisseurRepository;
import com.demo.depot.LigneCommandFournisseurRepository;
import com.demo.modele.dtos.CommandFournisseurDto;
import com.demo.modele.dtos.FournisseurDTO;
import com.demo.modele.dtos.LigneCommandFournisseurDTO;
import com.demo.modele.entites.Article;
import com.demo.modele.entites.CommandFournisseur;
import com.demo.modele.entites.EtatCommand;
import com.demo.modele.entites.Fournisseur;
import com.demo.modele.entites.LigneCommandFournisseur;
import com.demo.modele.mapper.CommandFournisseurMapper;
import com.demo.modele.mapper.FournisseurMapper;
import com.demo.modele.mapper.LigneCommandFournisseurMapper;
import com.demo.prestations_service.CommandFournisseurService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CommandFournisseurServiceImpl implements CommandFournisseurService {
private final CommandFournisseurRepository repository;
private final LigneCommandFournisseurRepository ligneCommandFournisseurRepository;
private final FournisseurRepository fournisseurRepository;	
private final ArticleRepository articleRepository;
@Override
	public CommandFournisseurDto save(CommandFournisseurDto commandFournisseurDTO) {
		return CommandFournisseurMapper.convertToDTO(repository.save(CommandFournisseurMapper.convertToEntity(commandFournisseurDTO)));
	}

	@Override
	public CommandFournisseurDto updateEtatComman(long idCommand, EtatCommand etatCommand) {
		CommandFournisseurDto commandFournisseur=checkEtatCommand(idCommand);
		if(commandFournisseur.isCommandLivree()) {
			throw new InvalidDnDOperationException("impossible de modifier etat de commande deja livree"); 
		}
		commandFournisseur.setEtatCommmand(etatCommand);
		return CommandFournisseurMapper.convertToDTO(repository.save(CommandFournisseurMapper.convertToEntity(commandFournisseur)));
	}

	@Override
	public CommandFournisseurDto updateQuantiteCommand(long idCommand, long idLigneCommand, BigDecimal quantite) {
		if(quantite==null||quantite.compareTo(BigDecimal.ZERO)==0){
			throw new InvalidDnDOperationException("impossible de modifier la quantite");
		}
		CommandFournisseurDto commandFournisseur=checkEtatCommand(idCommand);
		Optional<LigneCommandFournisseur> ligneCommandFournisseurOptional=findLigneCommandFournisseur(idLigneCommand);
		LigneCommandFournisseur  ligneCommandFournisseur=ligneCommandFournisseurOptional.get();
		ligneCommandFournisseur.setQuantite(quantite);
		ligneCommandFournisseurRepository.save(ligneCommandFournisseur);
		return commandFournisseur;
	}

	@Override
	public CommandFournisseurDto updateFournisseur(long idCommand, long idFournisseur) {
		CommandFournisseurDto commandFournisseur=checkEtatCommand(idCommand);
		Optional<Fournisseur> fournisseurOptional=fournisseurRepository.findById(idFournisseur);
		if(fournisseurOptional.isEmpty()) {
			throw new EntityNotFoundException("aucune fournisseur avec ce identifaint");
			
		}
		commandFournisseur.setFournisseur(FournisseurMapper.convertToDTO(fournisseurOptional.get()));
		return CommandFournisseurMapper.convertToDTO(repository.save(CommandFournisseurMapper.convertToEntity(commandFournisseur)));
	}

	@Override
	public CommandFournisseurDto updateArticle(long idCommand, long idLigneCommand, long idArticle) {
		CommandFournisseurDto commandFournisseur=checkEtatCommand(idCommand);
		Optional<LigneCommandFournisseur> ligneCommandFournisseur=findLigneCommandFournisseur(idLigneCommand);
		Optional<Article> articleOptional=articleRepository.findById(idArticle);
		if(articleOptional.isEmpty()) {
			throw new EntityNotFoundException("aucune article na ete trouvé ");
		}
		LigneCommandFournisseur ligneCommandFournisseurSave=ligneCommandFournisseur.get();
		ligneCommandFournisseurSave.setArticle(articleOptional.get());
		ligneCommandFournisseurRepository.save(ligneCommandFournisseurSave);
		return commandFournisseur;
		
	}
	

	@Override
	public CommandFournisseurDto deleteArticle(long idCommand, long idLigneCommand, long idArticle) {
		CommandFournisseurDto commandfournisseur=checkEtatCommand(idCommand);
		findLigneCommandFournisseur(idLigneCommand);
		ligneCommandFournisseurRepository.deleteById(idLigneCommand);
		return commandfournisseur;
	}

	@Override
	public CommandFournisseurDto findById(long id) {
		return repository.findById(id)
				.map(CommandFournisseurMapper::convertToDTO)
				.orElseThrow(()-> new EntityNotFoundException("pad de commande avec ce id"));
	}

	@Override
	public CommandFournisseurDto findByCode(String code) {
		return repository.findByCode(code)
				.map(CommandFournisseurMapper::convertToDTO)
				.orElseThrow(()-> new EntityNotFoundException("pas de commade fournisseur avec ce code"));
	}
	@Override
	public List<CommandFournisseurDto> findAll() {
		return repository.findAll()
				.stream()
				.map(CommandFournisseurMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<LigneCommandFournisseurDTO> findAllLigneCommandsFournisseurByCommandFournisseurId(long idCommand) {
		return ligneCommandFournisseurRepository.findAllByCommandFournisseurId(idCommand)
				.stream()
				.map(LigneCommandFournisseurMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}
	private CommandFournisseurDto checkEtatCommand(long idCommand) {
		CommandFournisseurDto commandFournisseur=findById(idCommand);
		if(commandFournisseur.isCommandLivree()) {
				throw new InvalidDnDOperationException("impossible de modifier la commande lorquelle est livree");
	}
		return commandFournisseur;

}
	private Optional<LigneCommandFournisseur> findLigneCommandFournisseur(long idLigneCommande){
		Optional<LigneCommandFournisseur> lignecommandFournisseurOptional=ligneCommandFournisseurRepository.findById(idLigneCommande);
		if(lignecommandFournisseurOptional.isEmpty()) {
			throw new EntityNotFoundException("aucune ligne commmande fournisseur na ete trouvé");
		}
		return lignecommandFournisseurOptional;
	}
	
}
