package com.demo.prestations_service.Implicite;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import com.demo.depot.ArticleRepository;
import com.demo.depot.CommandClientRepository;
import com.demo.depot.LigneCommandFournisseurRepository;
import com.demo.depot.LigneCommandRepository;
import com.demo.depot.LigneVenteRepository;
import com.demo.modele.dtos.ArticleDTO;
import com.demo.modele.dtos.LigneCommandClientDTO;
import com.demo.modele.dtos.LigneCommandFournisseurDTO;
import com.demo.modele.dtos.LigneVenteDTO;
import com.demo.modele.entites.LigneCommandClient;
import com.demo.modele.entites.LigneCommandFournisseur;
import com.demo.modele.entites.LigneVente;
import com.demo.modele.mapper.ArticleMapper;
import com.demo.modele.mapper.CategoryMapper;
import com.demo.modele.mapper.LigneCommandClientMapper;
import com.demo.modele.mapper.LigneCommandFournisseurMapper;
import com.demo.modele.mapper.LigneVenteMapper;
import com.demo.prestations_service.ArticleService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
private final ArticleRepository repository;
private final LigneVenteRepository ligneVenteRepository;
private final LigneCommandRepository ligneCommandClientRepository;
private final LigneCommandFournisseurRepository ligneCommandFournisseurRepository;	

@Override
	public ArticleDTO findById(long id) {
		return repository.findById(id)
				.map(ArticleMapper::convertToDTO)
				.orElseThrow(()-> new EntityNotFoundException("no article was found with this id"));
	}

	@Override
	public ArticleDTO findByCodeArticle(String codeArticle) {
		return repository.findByCodeArticle(codeArticle)
				.map(ArticleMapper::convertToDTO)
				.orElseThrow(()-> new EntityNotFoundException("no article was found with this id"));
	}

	@Override
	public List<ArticleDTO> findall() {
		return repository.findAll()
				.stream()
				.map(ArticleMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<LigneVenteDTO> findHistoriqueVentes(long idArticle) {
		return ligneVenteRepository.findAllByArticleId(idArticle)
				.stream()
				.map(LigneVenteMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<LigneCommandClientDTO> findHistoriqueCommandClient(long idArticle) {
		return ligneCommandClientRepository.findAllByArticleId(idArticle)
				.stream()
				.map(LigneCommandClientMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<LigneCommandFournisseurDTO> findHistoriqueCommandeFournisseur(long adArticle) {
		return ligneCommandFournisseurRepository.findAllByArticleId(adArticle)
				.stream()
				.map(LigneCommandFournisseurMapper::convertToDTO)
				.collect(Collectors.toList());
				}

	@Override
	public List<ArticleDTO> findAllArticleByIdCategory(long idCategory) {
		return repository.findAll()
				.stream()
				.map(ArticleMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(long id) {
		List<LigneCommandClient> ligneCommandClient=ligneCommandClientRepository.findAllByArticleId(id);
		if(!ligneCommandClient.isEmpty()) {
			throw new InvalidDnDOperationException("impossible de supprimer cet article il ya une commande de cet article");
		}
		List<LigneVente> ligneVentes=ligneVenteRepository.findAllByArticleId(id);
		if(!ligneVentes.isEmpty())
		{throw new InvalidDnDOperationException("impossible deffacer cet article");
	}
		List<LigneCommandFournisseur> ligneCommandeFournisseur=ligneCommandFournisseurRepository.findAllByArticleId(id);
		if(!ligneCommandeFournisseur.isEmpty()) {
			throw new InvalidDnDOperationException("impossible deffacer");
		}
		 repository.deleteById(id);

	}

	@Override
	public ArticleDTO save(ArticleDTO dto) {
		return ArticleMapper.convertToDTO(repository.save(ArticleMapper.convertToEntity(dto)));
	}

}
