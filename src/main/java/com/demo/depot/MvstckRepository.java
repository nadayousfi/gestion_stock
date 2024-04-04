package com.demo.depot;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.modele.entites.MVStk;

public interface MvstckRepository extends JpaRepository<MVStk, Long> {
}
