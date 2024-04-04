package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.FournisseurDTO;
import com.demo.modele.entites.Fournisseur;

public class FournisseurMapper {
	public static final ModelMapper modelMapper=new ModelMapper();
	public static FournisseurDTO convertToDTO(Fournisseur fournisseur) {
		return modelMapper.map(fournisseur, FournisseurDTO.class);
	}
	public static Fournisseur convertToEntity(FournisseurDTO fournisseurDTO) {
		return modelMapper.map(fournisseurDTO, Fournisseur.class);
	}
}
