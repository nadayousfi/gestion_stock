package com.demo.modele.entites;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Embedded;
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
public class Utilisateur extends AbstractEntity {
private String nom;
private String prenom;
private String email;
private Instant dateNaissance;
private String motDePasse;
@Embedded
private Adresse adresse;
private String photo;
@ManyToOne
@JsonIgnoreProperties("utilisateur")
@JoinColumn(name = "idEntreprise")
private Entreprise entreprise;
@OneToMany(mappedBy = "idUtilisateur")
@JsonIgnoreProperties("idUtilisateur")
private List<Roles> roles;
}
