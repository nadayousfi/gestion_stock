package com.demo.prestations_service;

import java.util.List;

import com.demo.modele.dtos.EntrepriseDTO;

public interface EntrepriseService {
public EntrepriseDTO save(EntrepriseDTO dto);
public EntrepriseDTO findById(long id);
public List<EntrepriseDTO> findAll();
public void delete(long id);
}
