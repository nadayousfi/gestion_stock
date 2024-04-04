package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.LigneCommandClientDTO;
import com.demo.modele.entites.LigneCommandClient;

public class LigneCommandClientMapper {
	public static final ModelMapper modelMapper=new ModelMapper();
	public static LigneCommandClientDTO convertToDTO(LigneCommandClient ligneCommandClient) {
		return modelMapper.map(ligneCommandClient, LigneCommandClientDTO.class);
	}
	public static LigneCommandClient convertToEntity(LigneCommandClientDTO ligneCommandClientDTO) {
		return modelMapper.map(ligneCommandClientDTO, LigneCommandClient.class);
	}
}
