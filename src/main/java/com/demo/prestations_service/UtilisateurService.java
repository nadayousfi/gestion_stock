package com.demo.prestations_service;

import java.util.List;
import com.demo.modele.dtos.changerMotDePasse;
import com.demo.modele.dtos.UserDTO;

public interface UtilisateurService {
public UserDTO save(UserDTO dto);
public UserDTO findById(long id);
public List<UserDTO> findAll();
public void delete(long id);
public UserDTO findByEmail(String email);
public UserDTO changerMotDePasse(changerMotDePasse dto);
}
