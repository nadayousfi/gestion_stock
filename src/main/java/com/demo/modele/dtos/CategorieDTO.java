package com.demo.modele.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategorieDTO {
	private String code;
	private String designation;
	private Integer idEntreprise;
	@JsonIgnoreProperties("category")
	private List<ArticleDTO> articles;
}
