package com.ecommerce.ProductService.services;

import com.ecommerce.ProductService.dtos.ProductResponseDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreServiceImpl implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductResponseDto getProductById(int id) {
        String getProductsUrl = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDto>response=restTemplate.getForEntity(getProductsUrl,ProductResponseDto.class);
        return response.getBody();
    }
}
