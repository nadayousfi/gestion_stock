package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.RoleDTO;
import com.demo.modele.entites.Roles;

public class RolesMapper {
	public static final ModelMapper modelMapper=new ModelMapper();
	public static RoleDTO convertToDTO(Roles roles) {
		return modelMapper.map(roles, RoleDTO.class);
	}
	public static Roles convertToEntity(RoleDTO roleDTO) {
		return modelMapper.map(roleDTO, Roles.class);
}}
