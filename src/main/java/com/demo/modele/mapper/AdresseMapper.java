package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.AdresseDTO;
import com.demo.modele.entites.Adresse;

public class AdresseMapper {
public static final ModelMapper modelMapper=new ModelMapper();
public static AdresseDTO convertToDTO(Adresse adresse) {
	return modelMapper.map(adresse, AdresseDTO.class);
}
public static Adresse convertToEntity(AdresseDTO adresseDTO) {
	return modelMapper.map(adresseDTO, Adresse.class);
}
}
