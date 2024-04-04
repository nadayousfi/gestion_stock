package com.demo.modele.mapper;

import org.modelmapper.ModelMapper;

import com.demo.modele.dtos.ArticleDTO;
import com.demo.modele.entites.Article;

public class ArticleMapper {
public static final ModelMapper modelMapper=new ModelMapper();
public static ArticleDTO convertToDTO (Article article) {
	return modelMapper.map(article, ArticleDTO.class);
}
public static Article convertToEntity (ArticleDTO articleDTO) {
	return modelMapper.map(articleDTO, Article.class);
}
}
