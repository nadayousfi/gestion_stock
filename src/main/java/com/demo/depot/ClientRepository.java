package com.demo.depot;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
