package com.ecommerce.ProductService.services;

import com.ecommerce.ProductService.dtos.ProductListResponseDto;
import com.ecommerce.ProductService.dtos.ProductRequestDto;
import com.ecommerce.ProductService.dtos.ProductResponseDto;
import com.ecommerce.ProductService.exception.ProductNotFoundException;
import com.ecommerce.ProductService.models.Product;

public interface ProductService {
    ProductListResponseDto getAllProducts();
    ProductResponseDto getProductById(int id)throws ProductNotFoundException;
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
}
