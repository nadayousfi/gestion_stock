package com.demo.modele.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleDTO {
	private String roleName;
	@JsonIgnoreProperties("roles")
	private UserDTO idUtilisateur;
}
