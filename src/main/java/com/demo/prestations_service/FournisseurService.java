package com.demo.prestations_service;

import java.util.List;

import com.demo.modele.dtos.FournisseurDTO;

public interface FournisseurService {
public FournisseurDTO save(FournisseurDTO dto);
public FournisseurDTO findById(long id);
public List<FournisseurDTO> findAll();
public void delete(long id);
}
