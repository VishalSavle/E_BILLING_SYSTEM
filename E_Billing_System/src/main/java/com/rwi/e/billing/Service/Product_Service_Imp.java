package com.rwi.e.billing.Service;

import org.springframework.http.ResponseEntity;

import com.rwi.e.billing.Entity.Repository.Product_Repository;
import com.rwi.e.billing.dto.Product_Dto;

public class Product_Service_Imp implements Product_Service{
	private Product_Repository product_Repository;
	@Override
	public ResponseEntity<?> addProduct(Product_Dto product_Dto) {
		
		return null;
	}
	
}
