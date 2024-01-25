package com.ecommerce.ProductService.services;

import com.ecommerce.ProductService.dtos.ProductListResponseDto;
import com.ecommerce.ProductService.dtos.ProductRequestDto;
import com.ecommerce.ProductService.dtos.ProductResponseDto;
import com.ecommerce.ProductService.models.Product;

public interface ProductService {
    ProductListResponseDto getAllProduct();
    ProductResponseDto getProductById(int id);
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
}
