package com.shoplite.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoplite.services.ProductService;

import dto.ProductRequestDTO;
import dto.ProductResponseDTO;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(
            @PathVariable Long id) {

        ProductResponseDTO product = productService.getProductById(id);

        if (product == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(
            @RequestBody ProductRequestDTO product) {

        ProductResponseDTO savedProduct = productService.addProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        if (productService.removeProductById(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequestDTO product) {

        ProductResponseDTO updatedProduct =
                productService.updateProduct(id, product);

        if (updatedProduct == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/category")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByCategory(
            @RequestParam String category) {

        return ResponseEntity.ok(
                productService.getProductsByCategory(category));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByNameContaining(
            @RequestParam String word) {

        return ResponseEntity.ok(
                productService.getProductsContainingName(word));
    }
}