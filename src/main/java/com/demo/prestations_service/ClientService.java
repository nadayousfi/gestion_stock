package com.demo.prestations_service;

import java.util.List;
import java.util.Optional;

import com.demo.modele.dtos.ClientDTO;

public interface ClientService {
public ClientDTO save(ClientDTO clientDTO);
public ClientDTO findById(long id);
public List<ClientDTO> findAll();
public void delete(long id);
}
