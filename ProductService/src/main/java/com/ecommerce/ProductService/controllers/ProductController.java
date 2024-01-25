package com.ecommerce.ProductService.controllers;

import com.ecommerce.ProductService.dtos.ProductResponseDto;
import com.ecommerce.ProductService.models.Product;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.ProductService.services.ProductService;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products/1")
   public ResponseEntity getProductById() {
        ProductResponseDto response = productService.getProductById(1);
        return ResponseEntity.ok(response);
    }
}
