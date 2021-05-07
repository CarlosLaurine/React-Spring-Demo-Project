package com.devsuperior.dssales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dssales.dto.SaleDTO;
import com.devsuperior.dssales.dto.SaleSuccessDTO;
import com.devsuperior.dssales.dto.SaleSumDTO;
import com.devsuperior.dssales.services.SaleService;

@RestController
@RequestMapping(value="/sales")

public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		
		Page<SaleDTO> page = saleService.findAll(pageable);
		
		return ResponseEntity.ok().body(page);
		
	}
	
	//Specifying Get Path
	@GetMapping(value = "/sum-per-seller")
	public ResponseEntity<List<SaleSumDTO>> saleAmountGroupedBySeller(){
		List<SaleSumDTO> sales = saleService.saleAmountGroupedBySeller();
		
		return ResponseEntity.ok().body(sales);
	}
	
	// Specifying Get Path
	
	@GetMapping(value = "/success-per-seller")
	
	public ResponseEntity<List<SaleSuccessDTO>> saleSuccessGroupedBySeller() {
		
		List<SaleSuccessDTO> sales = saleService.saleSuccessGroupedBySeller();

		return ResponseEntity.ok().body(sales);
	}
	
	
}





   













