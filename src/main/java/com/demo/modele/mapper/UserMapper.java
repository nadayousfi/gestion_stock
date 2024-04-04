package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.UserDTO;
import com.demo.modele.entites.Utilisateur;

public class UserMapper {
	public static final ModelMapper modelMapper=new ModelMapper();
	public static UserDTO convertToDTO(Utilisateur user) {
		return modelMapper.map(user, UserDTO.class);
	}
	public static Utilisateur convertToEntity(UserDTO userDTO) {
		return modelMapper.map(userDTO, Utilisateur.class);
}
}
