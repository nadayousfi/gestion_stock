package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.CategorieDTO;
import com.demo.modele.entites.Category;

public class CategoryMapper {
public static final ModelMapper modelMapper=new ModelMapper();
public static CategorieDTO convertToDTO(Category category) {
	return modelMapper.map(category, CategorieDTO.class);
}
public static Category convertToEntity(CategorieDTO categorieDTO) {
	return modelMapper.map(categorieDTO, Category.class);
}
}
