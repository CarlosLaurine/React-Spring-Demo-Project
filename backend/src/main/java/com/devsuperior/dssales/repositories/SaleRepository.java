package com.devsuperior.dssales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dssales.dto.SaleSuccessDTO;
import com.devsuperior.dssales.dto.SaleSumDTO;
import com.devsuperior.dssales.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	// Adding Customized Method (With JPQL's Dialect Query) to SaleRepository in order to 
	// perform a Grouped Query (Sale Sum + its Respective Seller) at the Database

	@Query("SELECT new com.devsuperior.dssales.dto.SaleSumDTO(sale.seller, SUM(sale.amount))"
			+ "FROM Sale AS sale GROUP BY sale.seller")
	//Setting Method's Signature to be Mapped by the @Query Annotation
	List<SaleSumDTO> saleAmountGroupedBySeller();

	@Query("SELECT new com.devsuperior.dssales.dto.SaleSuccessDTO(sale.seller, SUM(sale.visited), SUM(sale.deals))"
			+ "FROM Sale AS sale GROUP BY sale.seller")
	//Setting Method's Signature to be Mapped by the @Query Annotation
	List<SaleSuccessDTO> saleSuccessGroupedBySeller();

	
}
