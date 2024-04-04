package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.CommandFournisseurDto;
import com.demo.modele.entites.CommandFournisseur;

public class CommandFournisseurMapper {
public static final ModelMapper modelMapper=new ModelMapper();
public static CommandFournisseurDto convertToDTO(CommandFournisseur commandFournisseur) {
	return modelMapper.map(commandFournisseur, CommandFournisseurDto.class);
}
public static CommandFournisseur convertToEntity(CommandFournisseurDto commandFournisseurDTO) {
	return modelMapper.map(commandFournisseurDTO, CommandFournisseur.class);
}
}
