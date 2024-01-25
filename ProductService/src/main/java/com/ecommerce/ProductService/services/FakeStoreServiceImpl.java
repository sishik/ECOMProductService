package com.ecommerce.ProductService.services;

import com.ecommerce.ProductService.dtos.ProductListResponseDto;
import com.ecommerce.ProductService.dtos.ProductRequestDto;
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
    public ProductListResponseDto getAllProduct() {
        String getAllProductsUrl = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDto[]>productResponseArray=restTemplate.getForEntity(getAllProductsUrl,ProductResponseDto[].class);
        ProductListResponseDto productListResponseDto = new ProductListResponseDto();
        for(ProductResponseDto responseDto:productResponseArray.getBody()){
            productListResponseDto.getProducts().add(responseDto);
        }
        return productListResponseDto;


    }

    @Override
    public ProductResponseDto getProductById(int id) {
        String getProductsUrl = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDto>response=restTemplate.getForEntity(getProductsUrl,ProductResponseDto.class);
        return response.getBody();
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        String createProductsUrl = "https://fakestoreapi.com/products/";
                RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDto> response= restTemplate.postForEntity(createProductsUrl,productRequestDto,ProductResponseDto.class);
        return response.getBody();

    }
}
