package com.demo.prestations_service.Implicite;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.depot.ArticleRepository;
import com.demo.depot.CategorieRepository;
import com.demo.modele.dtos.CategorieDTO;
import com.demo.modele.entites.Article;
import com.demo.modele.mapper.CategoryMapper;
import com.demo.prestations_service.CategorieService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CategortieServiceImpl implements CategorieService {
private final CategorieRepository repository;
private final ArticleRepository articlRepository;
	@Override
	public CategorieDTO save(CategorieDTO categoryDTO) {
		return CategoryMapper.convertToDTO(repository.save(CategoryMapper.convertToEntity(categoryDTO)));
	}

	@Override
	public CategorieDTO findById(long id) {
		return repository.findById(id)
				.map(CategoryMapper::convertToDTO)
				.orElseThrow(()-> new EntityNotFoundException("non trouver"));
	}

	@Override
	public CategorieDTO findByCode(String code) {
		return repository.findByCode(code)
				.map(CategoryMapper::convertToDTO)
				.orElseThrow(()-> new EntityNotFoundException("non trouver"));
	}

	@Override
	public List<CategorieDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(CategoryMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(long id) {	
		List<Article> articles=articlRepository.findALLByCategoryId(id);
		if(!articles.isEmpty()) {
			throw new InvalidDnDOperationException("impossible deffacer");
		}
		repository.deleteById(id);
	}

}
