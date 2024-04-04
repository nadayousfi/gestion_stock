package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.CommandClientDTO;
import com.demo.modele.entites.CommandClient;

public class CommandClientMapper {
public static final ModelMapper modelMapper=new ModelMapper();
public static CommandClientDTO convertToDTO(CommandClient commandClient) {
	return modelMapper.map(commandClient, CommandClientDTO.class);
}
public static CommandClient convertToEntity(CommandClientDTO commandClientDTO) {
	return modelMapper.map(commandClientDTO, CommandClient.class);
}
}
