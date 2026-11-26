package com.shoplite.mappers;

import org.springframework.stereotype.Component;

import com.shoplite.models.Product;

import dto.ProductRequestDTO;
import dto.ProductResponseDTO;

@Component
public class ProductMapper {
	public Product toEntity(ProductRequestDTO dto) {

		return new Product(dto.getName(),dto.getDescription(),dto.getPrice(),dto.getQuantity(),dto.getCategory());

		
	}
	
	public ProductResponseDTO toDTO(Product product) {

		return  new ProductResponseDTO(product.getId(),
									   product.getName(),
									   product.getDescription(),
									   product.getPrice(),
									   product.getQuantity(),
									   product.getCategory());

		
				
	}

}
