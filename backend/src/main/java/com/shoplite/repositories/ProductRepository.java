package com.shoplite.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.shoplite.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByCategory(String category);
	
	List<Product> findByPriceLessThanEqual(Double price);
		
	List<Product> getByPriceBetween(Double pr1,Double pr2);
	
	List<Product> findByCategoryAndQuantityGreaterThan(
		    String category, int quantity);
	
	List<Product> findByNameContainingIgnoreCase(String word);
	
	List<Product> findAllByOrderByPriceAsc();
	
	long countByCategory(String category);
	
	
	//JPQL
	@Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max AND p.category = :category")
	List<Product> getProductsByPriceBetweenAndCategory(
	    @Param("min") Double min,
	    @Param("max") Double max,
	    @Param("category") String category);	
	
	@Query("SELECT AVG(p.price) FROM Product p WHERE p.category = :category")
	Double getAveragePriceForCategory(
	    @Param("category") String category);
	
	@Query("SELECT p FROM Product p WHERE p.quantity = 0 ORDER BY p.name ASC")
	List<Product> getSoldOutProducts();
	

	@Query("SELECT p.category, COUNT(p) FROM Product p GROUP BY p.category HAVING COUNT(p) > 5")
	List<Object[]> countProductsByCategory();
	
}