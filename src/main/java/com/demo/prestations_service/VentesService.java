package com.demo.prestations_service;

import java.util.List;

import com.demo.modele.dtos.VenteDTO;

public interface VentesService {
public VenteDTO save(VenteDTO dto);
public VenteDTO findById(long id);
public VenteDTO findByCode(String code);
public List<VenteDTO> findAll();
public void delete(long id);
}
