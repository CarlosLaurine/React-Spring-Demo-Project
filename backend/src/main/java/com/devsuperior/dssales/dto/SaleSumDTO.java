package com.devsuperior.dssales.dto;

import java.io.Serializable;

import com.devsuperior.dssales.entities.Seller;

public class SaleSumDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String sellerName;
	private Double sum;

	public SaleSumDTO() {

	}

	// Changing String name Parameter to Seller-Type in order to assure the
	// PostgreSQL Query will be able to group data by Seller, since it is not
	// possible to happen with just the varchar name

	public SaleSumDTO(Seller seller, Double sum) {
		this.sellerName = seller.getName();
		this.sum = sum;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
	

}
