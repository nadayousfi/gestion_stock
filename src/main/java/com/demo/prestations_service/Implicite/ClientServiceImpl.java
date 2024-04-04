package com.demo.prestations_service.Implicite;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.depot.ClientRepository;
import com.demo.depot.CommandClientRepository;
import com.demo.modele.dtos.ClientDTO;
import com.demo.modele.entites.CommandClient;
import com.demo.modele.mapper.ClientMapper;
import com.demo.prestations_service.ClientService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor

public class ClientServiceImpl implements ClientService {
private final ClientRepository repository;
private final CommandClientRepository commandClientRepository;
	@Override
	public ClientDTO save(ClientDTO clientDTO) {
		return ClientMapper.convertToDTO(repository.save(ClientMapper.convertToEntity(clientDTO)));
	}

	@Override
	public ClientDTO findById(long id) {
		return repository.findById(id)
				.map(ClientMapper::convertToDTO)
				.orElseThrow(()-> new EntityNotFoundException("non trouver"));
	}

	@Override
	public List<ClientDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(ClientMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(long id) {

		List<CommandClient> commandClients=commandClientRepository.findAllByClientId(id);
		if(!commandClients.isEmpty()) {
			throw new InvalidDnDOperationException("impossible deffacer ce client car il a une commande en cours ");
		}
		repository.deleteById(id);
	}

}
