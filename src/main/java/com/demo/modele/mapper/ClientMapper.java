package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.ClientDTO;
import com.demo.modele.entites.Client;

public class ClientMapper {
public static final ModelMapper modelMapper=new ModelMapper();
public static ClientDTO convertToDTO(Client client) {
	return modelMapper.map(client, ClientDTO.class);
}
public static Client convertToEntity(ClientDTO clientDto) {
	return modelMapper.map(clientDto, Client.class);
}
}
