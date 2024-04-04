package com.demo.modele.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class changerMotDePasse {
private long id;
private String motDePasse;
private String confirmMotDePass;
}
