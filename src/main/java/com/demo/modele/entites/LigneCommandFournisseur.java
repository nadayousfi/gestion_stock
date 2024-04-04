package com.demo.modele.entites;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
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
public class LigneCommandFournisseur extends AbstractEntity {
private BigDecimal quantite;
private BigDecimal prixUnitaire;
private Integer idEntreprise;
@ManyToOne
@JoinColumn(name = "idArticle")
private Article article;
@ManyToOne
@JsonIgnoreProperties("ligneCommandFournisseur")
@JoinColumn(name = "idCommandFournisseur")
private CommandFournisseur commandFournisseur;
}
