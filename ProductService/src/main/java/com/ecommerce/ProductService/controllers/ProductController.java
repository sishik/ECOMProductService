package com.ecommerce.ProductService.controllers;

import com.ecommerce.ProductService.dtos.ProductListResponseDto;
import com.ecommerce.ProductService.dtos.ProductRequestDto;
import com.ecommerce.ProductService.dtos.ProductResponseDto;
import com.ecommerce.ProductService.models.Product;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.ProductService.services.ProductService;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public ResponseEntity getAllproducts(){
        ProductListResponseDto responseDto = productService.getAllProduct();
        return ResponseEntity.ok(responseDto);
    }
    @GetMapping("/products/{id}")
   public ResponseEntity getProductById(@PathVariable("id")int id) {
        ProductResponseDto response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto responseDto = productService.createProduct(productRequestDto);
        return ResponseEntity.ok(responseDto);
    }
}
