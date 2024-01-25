package com.ecommerce.ProductService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private int id;
    private String title;
    private String description;
    private String image;
}
