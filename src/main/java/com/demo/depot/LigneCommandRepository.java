package com.demo.depot;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.LigneCommandClient;

public interface LigneCommandRepository extends JpaRepository<LigneCommandClient, Long> {
List<LigneCommandClient>findAllByArticleId(long id);
List<LigneCommandClient> findAllByCommandClientId(long idCommadeClient);
}
