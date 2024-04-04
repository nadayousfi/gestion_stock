package com.demo.modele.entites;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Embedded;
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
public class Client extends AbstractEntity {
private String nom;
private String prenom;
@Embedded
private Adresse adresse;
private String photo;
private String mail;
private String numTel;
private Integer idEntreprise;
@OneToMany(mappedBy = "client")
@JsonIgnoreProperties("client")
private List<CommandClient> commandeClients;

}
