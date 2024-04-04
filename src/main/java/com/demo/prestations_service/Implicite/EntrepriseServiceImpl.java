package com.demo.prestations_service.Implicite;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.depot.EntrepriseRepository;
import com.demo.modele.dtos.EntrepriseDTO;
import com.demo.modele.mapper.EntrepriseMapper;
import com.demo.prestations_service.EntrepriseService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class EntrepriseServiceImpl implements EntrepriseService {
private final EntrepriseRepository repository;
	@Override
	public EntrepriseDTO save(EntrepriseDTO dto) {
		return EntrepriseMapper.convertToDTO(repository.save(EntrepriseMapper.convertToEntity(dto)));
				
	}

	@Override
	public EntrepriseDTO findById(long id) {
		return repository.findById(id)
				.map(EntrepriseMapper::convertToDTO)
				.orElseThrow(()-> new EntityNotFoundException("pas de entreprise avec ce id"));
	}

	@Override
	public List<EntrepriseDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(EntrepriseMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

}

