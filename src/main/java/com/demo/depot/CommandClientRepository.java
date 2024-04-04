package com.demo.depot;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.CommandClient;

public interface CommandClientRepository extends JpaRepository<CommandClient, Long> {
List<CommandClient> findAllByClientId(long id);
Optional<CommandClient> findByCode(String code);
}
