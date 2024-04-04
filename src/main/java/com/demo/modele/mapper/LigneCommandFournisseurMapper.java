package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.LigneCommandFournisseurDTO;
import com.demo.modele.entites.LigneCommandFournisseur;

public class LigneCommandFournisseurMapper {
	public static final ModelMapper modelMapper=new ModelMapper();
	public static LigneCommandFournisseurDTO convertToDTO(LigneCommandFournisseur ligneCommandFournisseur) {
		return modelMapper.map(ligneCommandFournisseur, LigneCommandFournisseurDTO.class);
	}
	public static LigneCommandFournisseur convertToEntity(LigneCommandFournisseurDTO ligneCommandFournisseurDTO) {
		return modelMapper.map(ligneCommandFournisseurDTO, LigneCommandFournisseur.class);
	}
}
