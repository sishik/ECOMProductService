package com.ecommerce.ProductService.dtos;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class ProductListResponseDto {
    private List<ProductResponseDto>products;

    public ProductListResponseDto() {
        this.products = new ArrayList<>();
    }
}
