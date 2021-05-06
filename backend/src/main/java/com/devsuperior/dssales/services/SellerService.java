package com.devsuperior.dssales.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dssales.dto.SellerDTO;
import com.devsuperior.dssales.entities.Seller;
import com.devsuperior.dssales.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll(){
		
		List<Seller> sellerEntities = sellerRepository.findAll();
		return sellerEntities.stream().map(sellerEntity -> new SellerDTO(sellerEntity)).collect(Collectors.toList());
	}
}
