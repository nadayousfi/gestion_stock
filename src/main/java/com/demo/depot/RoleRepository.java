package com.demo.depot;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {

}
