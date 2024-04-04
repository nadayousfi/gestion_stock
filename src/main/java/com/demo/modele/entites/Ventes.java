package com.demo.modele.entites;

import java.time.Instant;
import java.util.List;

import com.demo.modele.dtos.LigneVenteDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
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
public class Ventes extends AbstractEntity {
private String code;
private Instant dateVente;
private String commentaire;
private Integer idEntrepriqe;
@OneToMany (mappedBy = "vente")
@JsonIgnoreProperties("vente")
private List<LigneVente> lignesVentes;

}
