package com.devsuperior.dssales.dto;

import java.io.Serializable;

import com.devsuperior.dssales.entities.Seller;

public class SaleSuccessDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String sellerName;
	private Long visited;
	private Long deals;

	public SaleSuccessDTO() {

	}

	// Changing String sellerName Parameter to Seller-Type in order to assure the
	// PostgreSQL Query will be able to group data by Seller, since it is not
	// possible to happen with just the varchar name
	
	public SaleSuccessDTO(Seller seller, Long visited, Long deals) {

		sellerName = seller.getName();
		this.visited = visited;
		this.deals = deals;
	
	}	

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Long getVisited() {
		return visited;
	}

	public void setVisited(Long visited) {
		this.visited = visited;
	}

	public Long getDeals() {
		return deals;
	}

	public void setDeals(Long deals) {
		this.deals = deals;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
