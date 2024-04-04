package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.LigneCommandFournisseurDTO;
import com.demo.modele.dtos.MvstckDTO;
import com.demo.modele.entites.LigneCommandFournisseur;
import com.demo.modele.entites.MVStk;

public class MvStckMapper {
	public static final ModelMapper modelMapper=new ModelMapper();
	public static MvstckDTO convertToDTO(MVStk mvStck) {
		return modelMapper.map(mvStck, MvstckDTO.class);
	}
	public static MVStk convertToEntity(MvstckDTO mvstckDTO) {
		return modelMapper.map(mvstckDTO, MVStk.class);
	}
}
