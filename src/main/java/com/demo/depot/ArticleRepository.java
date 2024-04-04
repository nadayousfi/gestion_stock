package com.demo.depot;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.dtos.ArticleDTO;
import com.demo.modele.entites.Article;
import java.util.List;


public interface ArticleRepository extends JpaRepository<Article, Long> {
Optional<Article> findByCodeArticle(String codeArticle);
List<Article> findALLByCategoryId(long id);
}
