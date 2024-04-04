package com.demo.prestations_service;

import java.util.List;
import java.util.Optional;

import com.demo.modele.dtos.ArticleDTO;
import com.demo.modele.dtos.LigneCommandClientDTO;
import com.demo.modele.dtos.LigneCommandFournisseurDTO;
import com.demo.modele.dtos.LigneVenteDTO;

public interface ArticleService {
public ArticleDTO save(ArticleDTO dto);
public ArticleDTO findById(long id);
public ArticleDTO findByCodeArticle(String codeArticle);
public List<ArticleDTO> findall();
public List<LigneVenteDTO> findHistoriqueVentes(long idArticle);
public List<LigneCommandClientDTO> findHistoriqueCommandClient(long idArticle);
public List<LigneCommandFournisseurDTO> findHistoriqueCommandeFournisseur(long adArticle);
public List<ArticleDTO> findAllArticleByIdCategory(long idCategory);
public void deleteById(long id);
}
