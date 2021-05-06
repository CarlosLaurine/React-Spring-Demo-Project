package com.devsuperior.dssales.services;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dssales.dto.SaleDTO;
import com.devsuperior.dssales.entities.Sale;
import com.devsuperior.dssales.repositories.SaleRepository;
import com.devsuperior.dssales.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private SellerRepository sellerRepository;

	// Implementing Data (Sales) Pagination through JpaRepository Interface's
	// Pageable attribute (Returns a Page instead of a List)

	// Setting all Database Queries to be run at this Service findaAll() Method
	// Scope, and defining that the Method will not perform any Locking at the
	// Database since the following performs just a Read Operation, which not
	// requires a Writing Operation Locking

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {

		// Since there are not much Sellers in this Application, in order for it to not
		// make Multiple Queries at the Database during Runtime, a findAll() method can
		// be called to set the Sellers at the Cache Memory for the JPA to use it
		// instead
		// of visiting the Database Multiple Times
		sellerRepository.findAll();

		Page<Sale> saleEntities = saleRepository.findAll(pageable);
		return saleEntities.map(saleEntity -> new SaleDTO(saleEntity));
	}
}
