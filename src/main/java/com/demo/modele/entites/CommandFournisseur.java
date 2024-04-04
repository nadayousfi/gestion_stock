package com.demo.modele.entites;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class CommandFournisseur extends AbstractEntity {
private String code;
private Instant dateCommand;
@Enumerated(EnumType.STRING)
private EtatCommand etatCommmand;
private Integer idEntreprise;
@ManyToOne
@JoinColumn(name = "idCommandFournisseur")
private Fournisseur fournisseur;
@OneToMany(mappedBy = "commandFournisseur")
private List<LigneCommandFournisseur> ligneCommandFournisseur;
}
