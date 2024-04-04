package com.demo.prestations_service;

import java.util.List;

import com.demo.modele.dtos.CategorieDTO;

public interface CategorieService {
public CategorieDTO save(CategorieDTO categoryDTO);
public CategorieDTO findById(long id);
public CategorieDTO findByCode(String code);
public List<CategorieDTO> findAll();
void deleteById(long id);
}
