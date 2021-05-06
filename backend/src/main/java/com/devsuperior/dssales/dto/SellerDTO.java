package com.devsuperior.dssales.dto;

import java.io.Serializable;

import com.devsuperior.dssales.entities.Seller;

public class SellerDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public SellerDTO() {
		
	}

	public SellerDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public SellerDTO(Seller seller) {
	    id = seller.getId();
		name = seller.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
