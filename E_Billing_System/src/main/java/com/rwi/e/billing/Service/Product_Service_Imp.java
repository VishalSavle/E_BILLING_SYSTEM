package com.rwi.e.billing.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rwi.e.billing.Entity.Product_Entity;
import com.rwi.e.billing.Entity.Repository.Product_Repository;
import com.rwi.e.billing.dto.Product_Dto;
@Service
public class Product_Service_Imp implements Product_Service{
	@Autowired
	private Product_Repository product_Repository;
	@Override
	public ResponseEntity<?> addProduct(Product_Dto product_Dto) {
		try {
		Optional<Product_Entity>ProductID=product_Repository.findById(product_Dto.getId());
		if(ProductID.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Product already exists");
		}
		Product_Entity addproduct=new Product_Entity();
		addproduct.setName(product_Dto.getName());
		addproduct.setDiscount(product_Dto.getDiscount());
		addproduct.setPrice(product_Dto.getPrice());
		addproduct.setUnits(product_Dto.getUnits());
		addproduct.setMfd(product_Dto.getMfd());
		addproduct.setExp(product_Dto.getExp());
		addproduct.setGst(product_Dto.getGst());
		product_Repository.save(addproduct);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Product add success");
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Getting Some error");
		}
	}
	
}
