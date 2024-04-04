package com.demo.prestations_service.Implicite;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.depot.UserRepository;
import com.demo.modele.dtos.UserDTO;
import com.demo.modele.mapper.UserMapper;
import com.demo.prestations_service.UtilisateurService;
import com.demo.modele.dtos.changerMotDePasse;
import com.demo.modele.entites.Utilisateur;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UtilisateurService {
private final UserRepository repository;
	@Override
	public UserDTO save(UserDTO dto) {
		return UserMapper.convertToDTO(repository.save(UserMapper.convertToEntity(dto)));
	}

	@Override
	public UserDTO findById(long id) {
		return repository.findById(id)
				.map(UserMapper::convertToDTO)
				.orElseThrow(()->new EntityNotFoundException("aucun user a ete trouvé "));
	}

	@Override
	public List<UserDTO> findAll() {
		return repository.findAll()
				.stream()
				.map(UserMapper::convertToDTO)
				.collect(Collectors.toList());
				}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

	@Override
	public UserDTO findByEmail(String email) {
		return repository.findByEmail(email)
				.map(UserMapper::convertToDTO)
				.orElseThrow(()-> new EntityNotFoundException("aucun email a ete trouvé "));
	}

	@Override
	public UserDTO changerMotDePasse(changerMotDePasse dto) {
		validate(dto);
		Optional<Utilisateur> utilisateurOptional=repository.findById(dto.getId());
		if(utilisateurOptional.isEmpty()) {
			throw new EntityNotFoundException("aucu utilisateur na ete pas trouvé ");
		}
		Utilisateur utilisateur=utilisateurOptional.get();
		utilisateur.setMotDePasse(dto.getMotDePasse());
		return UserMapper.convertToDTO(repository.save(utilisateur));
	}
private void validate( changerMotDePasse dto) {
	if(dto==null) {
		throw new EntityNotFoundException("impossible de modifier");
	}
	
}
}
