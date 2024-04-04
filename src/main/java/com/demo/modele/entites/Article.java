package com.demo.modele.entites;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Article extends AbstractEntity {
private String codeArticle;
private String designation;
private BigDecimal prixUnitaire;
private String photo;
private Integer idEntreprise;
@ManyToOne
@JsonIgnoreProperties("articles")
@JoinColumn(name = "idcategory")
private Category category;
@OneToMany(mappedBy = "article")
@JsonIgnoreProperties("article")
private List<LigneVente> ligneVentes;
@OneToMany(mappedBy = "article")
@JsonIgnoreProperties("article")
private List<LigneCommandClient> ligneCommandClients;
@OneToMany(mappedBy = "article")
@JsonIgnoreProperties("article")
private List<LigneCommandFournisseur> ligneCommandFournisseur;
@OneToMany(mappedBy = "article")
@JsonIgnoreProperties("article")
private List<MVStk> mvStcs;
}
