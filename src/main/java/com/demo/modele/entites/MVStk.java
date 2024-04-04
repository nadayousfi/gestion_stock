package com.demo.modele.entites;

import java.math.BigDecimal;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties({"hibernateLazyInitialiser","handler"})
public class MVStk extends AbstractEntity {
private Instant dateMvt;
private BigDecimal quantite;
 @Enumerated(EnumType.STRING)
 private TypeMvStck typeMvt;
 @Enumerated(EnumType.STRING)
 private SourcMvStck sourceMvt;
 private Integer idEntreprise;
 @ManyToOne
 @JsonIgnoreProperties("mvStcs")
 @JoinColumn(name = "idArticle")
 private Article article;
 
}
