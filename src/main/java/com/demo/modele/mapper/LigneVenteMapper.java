package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.LigneVenteDTO;
import com.demo.modele.entites.LigneVente;

public class LigneVenteMapper {
	public static final ModelMapper modelMapper=new ModelMapper();
	public static LigneVenteDTO convertToDTO(LigneVente ligneVente) {
		return modelMapper.map(ligneVente, LigneVenteDTO.class);
	}
	public static LigneVente convertToEntity(LigneVenteDTO ligneVenteDTO) {
		return modelMapper.map(ligneVenteDTO, LigneVente.class);
	}
}
