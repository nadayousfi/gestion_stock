 package com.demo.prestations_service;

import java.math.BigDecimal;
import java.util.List;

import com.demo.modele.dtos.MvstckDTO;

public interface MvStckService {
public BigDecimal stockReelArticle(long id);
public List<MvstckDTO> mvStkArticle(long idArticle);
public MvstckDTO entreeStock(MvstckDTO dto);
public MvstckDTO sortieStock(MvstckDTO dto);
public MvstckDTO correctionStockPos(MvstckDTO dto);
public MvstckDTO correctionStockNeg(MvstckDTO dto);
}
