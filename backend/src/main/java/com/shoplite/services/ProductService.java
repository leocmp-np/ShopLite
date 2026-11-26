package com.shoplite.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.shoplite.mappers.ProductMapper;
import com.shoplite.models.Product;
import com.shoplite.repositories.ProductRepository;

import dto.ProductRequestDTO;
import dto.ProductResponseDTO;
import jakarta.transaction.Transactional;

@Service()
public class ProductService {
	
		private final ProductRepository productRepo;
		private final ProductMapper productMap;
		
		public ProductService(ProductRepository productRepo,ProductMapper productMap) {
			this.productRepo = productRepo;
			this.productMap = productMap;
		}
		
		public ProductResponseDTO addProduct(ProductRequestDTO dto) {
		    Product product = productMap.toEntity(dto);
		    return productMap.toDTO(productRepo.save(product));
		}

		
		public List<ProductResponseDTO> getAllProducts() {
		    return productRepo.findAll()
		            .stream()
		            .map(productMap::toDTO)
		            .toList();
		}
		
		
		//return a product by its ID
		public ProductResponseDTO getProductById(Long id) {
		    return productRepo.findById(id)
		            .map(productMap::toDTO)
		            .orElse(null);
		}
		
		public List<ProductResponseDTO> getProductsByCategory(String category) {
		    return productRepo.findByCategory(category)
		            .stream()
		            .map(productMap::toDTO)
		            .toList();
		}

		
		public List<ProductResponseDTO> getProductsContainingName(String name) {
		    return productRepo.findByNameContainingIgnoreCase(name)
		            .stream()
		            .map(productMap::toDTO)
		            .toList();
		}
		
		
		/*
		

		
		public List<Product> getProductsByMaxPrice(Double maxPrice) {
		    return products.stream().filter(p -> p.getPrice() <= maxPrice).toList();
		}*/
		
		public long countProducts() {
		    return productRepo.count();
		}
		
		
		
		/*
		public List<String> getAllProductNames() {

		    return products.stream().map(p -> p.getName()).toList();

		}*/
		
		public boolean removeProductById(Long id) {

		    if (!productRepo.existsById(id))
		        return false;

		    productRepo.deleteById(id);

		    return true;
		}
		

		@Transactional
		public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {

		    Product product = productRepo.findById(id).orElse(null);

		    if (product == null)
		        return null;

		    product.setName(dto.getName());
		    product.setDescription(dto.getDescription());
		    product.setPrice(dto.getPrice());
		    product.setQuantity(dto.getQuantity());
		    product.setCategory(dto.getCategory());

		    return productMap.toDTO(product);
		}
	
}