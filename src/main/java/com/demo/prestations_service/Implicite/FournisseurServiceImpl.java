package com.demo.prestations_service.Implicite;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.depot.FournisseurRepository;
import com.demo.modele.dtos.FournisseurDTO;
import com.demo.modele.mapper.FournisseurMapper;
import com.demo.prestations_service.FournisseurService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class FournisseurServiceImpl implements FournisseurService {
private final FournisseurRepository repository;
	@Override
	public FournisseurDTO save(FournisseurDTO dto) {
		return FournisseurMapper.convertToDTO(repository.save(FournisseurMapper.convertToEntity(dto)));
	}

	@Override
	public FournisseurDTO findById(long id) {
		return repository.findById(id)
				.map(FournisseurMapper::convertToDTO)
				.orElseThrow(()-> new EntityNotFoundException(" aucun fournisseur trouvé avec ce id"));
	}

	@Override
	public List<FournisseurDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(FournisseurMapper::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

}
