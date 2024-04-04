package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.EntrepriseDTO;
import com.demo.modele.entites.Entreprise;

public class EntrepriseMapper {
public static final ModelMapper modelMapper=new ModelMapper();
public static EntrepriseDTO convertToDTO(Entreprise entreprise) {
	return modelMapper.map(entreprise, EntrepriseDTO.class);
}
public static Entreprise convertToEntity(EntrepriseDTO entrepriseDTO) {
	return modelMapper.map(entrepriseDTO, Entreprise.class);
}
}
