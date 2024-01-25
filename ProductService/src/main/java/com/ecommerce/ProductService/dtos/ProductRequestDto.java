package com.ecommerce.ProductService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
