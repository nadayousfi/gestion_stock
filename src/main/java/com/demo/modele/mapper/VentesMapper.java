package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.VenteDTO;
import com.demo.modele.entites.Ventes;

public class VentesMapper {
private static ModelMapper modelMapper=new ModelMapper();
public static VenteDTO convertDto(Ventes vente) {
	return modelMapper.map(vente, VenteDTO.class);
}
public static Ventes convertToEntity(VenteDTO venteDTO) {
	return modelMapper.map(venteDTO, Ventes.class);
}

}
