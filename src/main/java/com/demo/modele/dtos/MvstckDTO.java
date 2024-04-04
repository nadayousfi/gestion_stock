package com.demo.modele.dtos;

import java.math.BigDecimal;
import java.time.Instant;

import com.demo.modele.entites.SourcMvStck;
import com.demo.modele.entites.TypeMvStck;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MvstckDTO {
	private Instant dateMvt;
	private BigDecimal quantite;
	 private TypeMvStck typeMvt;
	 private SourcMvStck sourceMvt;
	 private Integer idEntreprise;
	 private ArticleDTO article;
}
