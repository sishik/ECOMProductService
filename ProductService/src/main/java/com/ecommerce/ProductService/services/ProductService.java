package com.ecommerce.ProductService.services;

import com.ecommerce.ProductService.dtos.ProductResponseDto;
import com.ecommerce.ProductService.models.Product;

public interface ProductService {
    ProductResponseDto getProductById(int id);
}
