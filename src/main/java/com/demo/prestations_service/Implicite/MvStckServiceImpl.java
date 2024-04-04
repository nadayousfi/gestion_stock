
package com.demo.prestations_service.Implicite;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.depot.MvstckRepository;
import com.demo.modele.dtos.MvstckDTO;
import com.demo.prestations_service.MvStckService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MvStckServiceImpl implements MvStckService {
private final MvstckRepository repository;
	@Override
	public BigDecimal stockReelArticle(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MvstckDTO> mvStkArticle(long idArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MvstckDTO entreeStock(MvstckDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MvstckDTO sortieStock(MvstckDTO dto) {
		return sortieStock(dto);
	}

	@Override
	public MvstckDTO correctionStockPos(MvstckDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MvstckDTO correctionStockNeg(MvstckDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
