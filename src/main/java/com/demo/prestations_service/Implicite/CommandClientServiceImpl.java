package com.demo.prestations_service.Implicite;

import java.awt.dnd.InvalidDnDOperationException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.depot.ArticleRepository;
import com.demo.depot.ClientRepository;
import com.demo.depot.CommandClientRepository;
import com.demo.depot.LigneCommandRepository;
import com.demo.modele.dtos.CommandClientDTO;
import com.demo.modele.dtos.LigneCommandClientDTO;
import com.demo.modele.entites.Article;
import com.demo.modele.entites.Client;
import com.demo.modele.entites.EtatCommand;
import com.demo.modele.entites.LigneCommandClient;
import com.demo.modele.mapper.ClientMapper;
import com.demo.modele.mapper.CommandClientMapper;
import com.demo.modele.mapper.LigneCommandClientMapper;
import com.demo.prestations_service.CommandClientService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CommandClientServiceImpl implements CommandClientService{
private final CommandClientRepository repository;
private final LigneCommandRepository ligneCommandclientRepository;
private final ClientRepository clientRepository;	
private final ArticleRepository articleRepository;
@Override
	public CommandClientDTO save(CommandClientDTO dto) {
		return CommandClientMapper.convertToDTO(repository.save(CommandClientMapper.convertToEntity(dto)));
		
	}

	@Override
	public CommandClientDTO update(long idCommande, EtatCommand etat) {
		CommandClientDTO commandClient=findById(idCommande);
		if(commandClient.isCommandLivree()) {
			throw new InvalidDnDOperationException("invalid de modifier l commande");
		}
		commandClient.setEtatCommand(etat);
		return CommandClientMapper.convertToDTO(repository.save(CommandClientMapper.convertToEntity(commandClient)));
	}

	@Override
	public CommandClientDTO updateQuantiteCommand(long idCommande, long idLigneCommand, BigDecimal quantite) {
		if(quantite==null || quantite.compareTo(BigDecimal.ZERO)==0) {
			throw new InvalidDnDOperationException("impossible de modifier letat de la commande");
		}
		CommandClientDTO commandClient=findById(idCommande);
		if(commandClient.isCommandLivree()) {
			throw new InvalidDnDOperationException("impossible de modifier la commande lorsqu'elle est livree");
		}
		Optional<LigneCommandClient> ligneCommandClientOptional =ligneCommandclientRepository.findById(idCommande);
			if(ligneCommandClientOptional.isEmpty()) {
				throw new InvalidDnDOperationException("aucune ligne commande na ete trouvé avec l id");
			}
			LigneCommandClient ligneCommandeClient=ligneCommandClientOptional.get();
			ligneCommandeClient.setQuantite(quantite);
			ligneCommandclientRepository.save(ligneCommandeClient);
			return commandClient;
			}

	@Override
	public CommandClientDTO updateClient(long idCommand, long idClient) {
		CommandClientDTO commandClient=checkEtatCommand(idCommand);
		Optional<Client> clientOptional =clientRepository.findById(idClient);
		if(clientOptional.isEmpty()) {
			throw new EntityNotFoundException("aucun client na ete trouvé avec ce id");
		}
		commandClient.setClient(ClientMapper.convertToDTO(clientOptional.get()));
		return CommandClientMapper.convertToDTO(repository.save(CommandClientMapper.convertToEntity(commandClient)));
		
	}

	@Override
	public CommandClientDTO updateArticle(long idCommand, long idLigneCommand, long idArticle) {
		CommandClientDTO commandClient=checkEtatCommand(idCommand);
		Optional<LigneCommandClient> ligneCommandClient=findLigneCommandClient(idLigneCommand);
		Optional<Article> articleOptional=articleRepository.findById(idArticle);
		if(articleOptional.isEmpty()) {
			throw new EntityNotFoundException("aucun article na ete trouve avec ce id ");
			
		}
		LigneCommandClient ligneCommandClientToSave=ligneCommandClient.get();
		ligneCommandClientToSave.setArticle(articleOptional.get());
		ligneCommandclientRepository.save(ligneCommandClientToSave);
		return commandClient;
	}

	@Override
	public CommandClientDTO deleteArticle(long idCommand, long idLigneCommand) {
		CommandClientDTO commandClient=checkEtatCommand(idCommand);
		//findLigneCommandeClient(idLigneCommand);
		ligneCommandclientRepository.deleteById(idLigneCommand);
		return commandClient;
	}

	@Override
	public CommandClientDTO findById(long id) {
		return repository.findById(id)
				.map(CommandClientMapper::convertToDTO)
				.orElseThrow(()-> new EntityNotFoundException("pas de command client avec ce id"));
	}

	@Override
	public CommandClientDTO findByCode(String code) {
		return repository.findByCode(code)
				.map(CommandClientMapper::convertToDTO)
				.orElseThrow(()->new EntityNotFoundException("pas de commande client avec ce code"));
	}

	@Override
	public List<CommandClientDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(CommandClientMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<LigneCommandClientDTO> findAllLignesCommandesClientByCommandClientId(long idCommand) {
		return ligneCommandclientRepository.findAllByCommandClientId(idCommand)
				.stream()
				.map(LigneCommandClientMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}
	private CommandClientDTO checkEtatCommand(long idCommand) {
		CommandClientDTO commandClient=findById(idCommand);
		if(commandClient.isCommandLivree()) {
			throw new InvalidDnDOperationException("impossible de modifier lorquelle est livrée ");
		}
		return commandClient;
	}
	private Optional<LigneCommandClient> findLigneCommandClient(long idLigneCommand){
		Optional<LigneCommandClient> ligneCommandClientOptional=ligneCommandclientRepository.findById(idLigneCommand);
		if(ligneCommandClientOptional.isEmpty()) {
			throw new EntityNotFoundException("aucun ligne de commmande na ete trouvé avec ce id");
		}
		return ligneCommandClientOptional;
	}

}
