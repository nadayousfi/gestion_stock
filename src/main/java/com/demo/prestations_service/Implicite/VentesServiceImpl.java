package com.demo.prestations_service.Implicite;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.depot.VenteRepository;
import com.demo.modele.dtos.VenteDTO;
import com.demo.modele.mapper.VentesMapper;
import com.demo.prestations_service.VentesService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class VentesServiceImpl implements VentesService {
private final VenteRepository repository;
	@Override
	public VenteDTO save(VenteDTO dto) {
		return VentesMapper.convertDto(repository.save(VentesMapper.convertToEntity(dto)));
	}

	@Override
	public VenteDTO findById(long id) {
		return repository.findById(id)
				.map(VentesMapper::convertDto)
				.orElseThrow(()-> new EntityNotFoundException("aucuun vente avec ce id"));
	}

	@Override
	public VenteDTO findByCode(String code) {
		return repository.findByCode(code)
				.map(VentesMapper::convertDto)
				.orElseThrow(()-> new EntityNotFoundException("aucun vente avec ce code"));
	}

	@Override
	public List<VenteDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(VentesMapper::convertDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

}
